import React, { useState } from 'react';
import './App.css';
import axios from 'axios';
import { Form, Button, FormGroup, FormControl } from "react-bootstrap";
import { Redirect } from 'react-router-dom';

const BACKEND_URL = 'http://localhost:8081';
const BACKEND_VM_URL = 'http://137.117.229.78:8080';
const RECEIPTS_URL = BACKEND_URL + '/Items';

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
            name
        );
        axios.post(
            RECEIPTS_URL,
            {
                id: id,
                created_at: created_at,
                updated_at: updated_at,
                name: name,
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

    if(success){
        return <Redirect to ="/receipts" />
    }

    return (
        <div className="AddReceipts">
            <h1>Add a Receipt</h1>
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
            {['checkbox'].map((type) => (
            <div key={`custom-inline-${type}`} className="mb-3">
            <Form.Check
                custom
                inline
                label="item-1"
                type={type}
                id={`custom-inline-${type}-1`}
            />
            <Form.Check
                custom
                inline
                label="item-2"
                type={type}
                id={`custom-inline-${type}-2`}
            />
            <Form.Check
                custom
                inline
                label="item-3"
                type={type}
                id={`custom-inline-${type}-3`}
            />
            </div>
        ))}
            </FormGroup>
            <br/>
            <br/>
            <Button block bsSize="large" onClick={handleClick} id="button">
                Add
            </Button>
        </div>
    );

}
