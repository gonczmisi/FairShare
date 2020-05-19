import React, { useState, useEffect } from 'react';
import './App.css';
import axios from 'axios';
import { Form, Button, FormGroup, FormControl } from "react-bootstrap";
import { Redirect } from 'react-router-dom';
import { useAuth } from './context/Auth';

const BACKEND_URL = 'http://localhost:8081';
const BACKEND_VM_URL = 'http://137.117.229.78:8081';
const RECEIPTS_URL = BACKEND_URL + '/receipts';
const ITEMS_URL = BACKEND_URL + '/items';


export default function AddItems() {
    const [name, setName] = useState("");
    const [price, setPrice] = useState("");
    const [currency_type, setCurrency] = useState("");
    const [error, setError] = useState(false);
    const [success, setSuccess] = useState(false);
    const [items, setItems] = useState([]);

    const { authTokens } = useAuth();
    
    useEffect((props) => {
        axios.get(
            ITEMS_URL,
            {
              auth: {
                username: authTokens.username,
                password: authTokens.password
              }
            }
          )
            .then(response => {
              if (response.status === 200) {
                console.log(response.data);
                const items = response.data;
                setItems(items);
              } else {
                console.log("ERROR");
                alert("Error!");
              }
            })
            .catch(error => {
              console.log(error);
              alert("Error!");
            });
    },
    []
    );

    function handleClick(event) {
        console.log(
            name
        );
        axios.post(
            RECEIPTS_URL,
            {
                name: name,
            },
            {
                auth: {
                    username: authTokens.username,
                    password: authTokens.password
                }
            }
        )
            .then(function res(response) {
                console.log(response);
                if (response.status === 200) {
                    alert("Successfully added an receipt");
                    setSuccess(true);
                } else {
                    alert("Something went wrong!");
                    console.log("Something went wrong!");
                    setError(true);
                }
            })
            .catch(function (error) {
                console.log(error);
                alert("Something went wrong!");
                setError(true);
            });

    }

    if (success) {
        return <Redirect to="/receipts" />
    }

    return (
        <div className="AddReceipts">
            <img src={require('./fsra.png')} />
            <br />
            <br />
            <FormGroup controlId="name" bsSize="large">
                <b>Name of the receipt: </b>
                <FormControl
                    id="inputbox"
                    autoFocus
                    type="text"
                    value={name}
                    onChange={e => setName(e.target.value)}
                />
            </FormGroup>
            <br />
            <FormGroup controlId="Price" bsSize="large">
                <b>Price of the receipt: </b>
                <FormControl
                    id="inputbox"
                    autoFocus
                    type="number"
                    value={price}
                    onChange={e => setPrice(e.target.value)}
                />
            </FormGroup>
            <br />
            <FormGroup controlId="added_items" bsSize="large">
                {items &&
                    items.map((item) =>
                        <Form.Check
                            custom
                            inline
                            label={item.name}
                            id={item.id}
                        />
                    )
                }
            </FormGroup>
            <br />
            <br />
            <Button block bsSize="large" onClick={handleClick} id="button">
                Add
            </Button>
        </div>
    );

}
