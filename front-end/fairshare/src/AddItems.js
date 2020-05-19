import React, { useState } from 'react';
import './App.css';
import axios from 'axios';
import { Button, FormGroup, FormControl } from "react-bootstrap";
import { Redirect } from 'react-router-dom';
import { useAuth } from './context/Auth';

const BACKEND_URL = 'http://localhost:8080';
const BACKEND_VM_URL = 'http://137.117.229.78:8080';
const ITEMS_URL = BACKEND_URL + '/items';

export default function AddItems() {
    const [name, setName] =  useState("");
    const [price, setPrice] =  useState("");
    const [currency_type, setCurrency] =  useState("HUF");
    const [error, setError] = useState(false);
    const [success, setSuccess] = useState(false);

    const { authTokens } = useAuth();

    function handleClick(event) {
        console.log(
            name,
            price,
            currency_type
        );
        axios.post(
            ITEMS_URL,
            {
                name: name,
                price: price,
                currencyType: currency_type
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
                    alert("Successfully added an item");
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

    if(success){
        return <Redirect to ="/items" />
    }

    return (
        <div className="AddItems">
            <img src={require('./fsia.png')} />
            <br />
            <br />
            <FormGroup controlId="name" bsSize="large">
                <b>Name of the item: </b>
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
                <b>Price of the item: </b>
                    <FormControl
                    id="inputbox"
                    autoFocus
                    type="number"
                    value={price}
                    onChange={e => setPrice(e.target.value)}
                />
            </FormGroup>
            <br />
            <FormGroup controlId="currency_type" bsSize="large">
                <b>Currency: </b>
                    <FormControl
                    id="selectBox"
                    as="select"
                    type="text"
                    value={currency_type}
                    onChange={e => setCurrency(e.target.value)}>
                            <option>HUF</option>
                            <option>USD</option>
                            <option>EUR</option>
                    </FormControl>
            </FormGroup>
            <br/>
            <br/>
            <Button block bsSize="large" onClick={handleClick} id="button">
                Add
            </Button>
        </div>
    );

}
