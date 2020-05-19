import React, { useState } from 'react';
import './App.css';
import axios from 'axios';
import { Button, FormGroup, FormControl } from "react-bootstrap";
import { Redirect } from 'react-router-dom';

const BACKEND_URL = 'http://localhost:8081';
const BACKEND_VM_URL = 'http://137.117.229.78:8080';
const REGISTER_URL = BACKEND_URL + '/register';

export default function Register() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");
    const [error, setError] = useState(false);
    const [success, setSuccess] = useState(false);

    function validateForm() {
        return password.length > 0 && username.length > 0 && email.length > 0;
    }

    function handleClick(event) {
        console.log(
            username,
            password,
            email
        );
        axios.post(
            REGISTER_URL,
            {
                username: username,
                password: password,
                emailAddress: email,
                userRole: "USER"
            }
        )
            .then(function res(response) {
                console.log(response);
                if (response.status === 200) {
                    alert("Successful registration! \nFeel free to login!");
                    setSuccess(true);
                } else {
                    alert("Wrong credentials!");
                    console.log("Wrong credentials!");
                    setError(true);
                }
            })
            .catch(function (error) {
                console.log(error);
                alert("Wrong credentials!");
                setError(true);
            });

    }

    if(success){
        return <Redirect to ="/login" />
    }

    return (
        <div className="Register">
            <img src={require('./fsregister.png')} />
            <br />
            <br />
            <FormGroup controlId="username" bsSize="large">
                <b>Username: </b>
                    <FormControl
                    autoFocus
                    type="username"
                    value={username}
                    onChange={e => setUsername(e.target.value)}
                />
            </FormGroup>
            <br />
            <FormGroup controlId="Email" bsSize="large">
                <b>Email address: </b>
                    <FormControl
                    autoFocus
                    type="email"
                    value={email}
                    onChange={e => setEmail(e.target.value)}
                />
            </FormGroup>
            <br />
            <FormGroup controlId="password" bsSize="large">
                <b>Password: </b>
                    <FormControl
                    value={password}
                    onChange={e => setPassword(e.target.value)}
                    type="password"
                />
            </FormGroup>
            <br/>
            <br/>
            <Button block bsSize="large" onClick={handleClick} disabled={!validateForm()}>
                Sing up
            </Button>
        </div>
    );

}