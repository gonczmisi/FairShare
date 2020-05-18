import React, { useState } from 'react';
import './App.css';
import axios from 'axios';
import { Button, FormGroup, FormControl } from "react-bootstrap";
import { Redirect } from 'react-router-dom';

const BACKEND_URL = 'http://localhost:8081';
const BACKEND_VM_URL = 'http://137.117.229.78:8080';
const ITEMS_URL = BACKEND_URL + '/Items';

export default function AddItems() {
    const [id, setId] = useState("");
    const [created_at, setCreation] = useState("");
    const [updated_at, setUpdate] = useState("");
    const [name, setName] =  useState("");
    const [price, setPrice] =  useState("");
    const [currency_type, setCurrency] =  useState("");
    const [error, setError] = useState(false);
    const [success, setSuccess] = useState(false);

    function handleClick(event) {
        console.log(
            id,
            created_at,
            updated_at,
            name,
            price,
            currency_type
        );
        axios.post(
            ITEMS_URL,
            {
                id: id,
                created_at: created_at,
                updated_at: updated_at,
                name: name,
                price: price,
                currency_type: currency_type
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
            <h1>Add an Item</h1>
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
