import React, { useState } from 'react';
import './App.css';
import axios from 'axios';
import { Button, FormGroup, FormControl } from "react-bootstrap";
import { useAuth } from './context/Auth';
import { Redirect } from 'react-router-dom';

const BACKEND_URL = 'http://localhost:8080';
const BACKEND_VM_URL = 'http://137.117.229.78:8080';
const USER_URL = BACKEND_URL + '/user';
const LOGIN_URL = BACKEND_URL + '/login';

export default function Login() {
    const { setAuthTokens } = useAuth();

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [success, setSuccess] = useState(null);

    function validateForm() {
        return password.length > 0 && username.length > 0;
    }

    function handleSubmit(event) {
        console.log(username, password)
        console.log(LOGIN_URL);
        axios.post(
            LOGIN_URL,
            {},
            {
                auth: {
                    username: username,
                    password: password
                }
            }
        )
            .then(function (response) {
                console.log(response);
                if (response.status === 200) {
                    console.log("Login successfull");
                    response.data.password = password;
                    setAuthTokens(response.data);
                    setSuccess(true);
                } else {
                    setSuccess(false);
                }
            })
            .catch(error => {
                console.log(error);
                setSuccess(false);
            });
    };

    if(success){
        return <Redirect to="/receipts" />
    }

    return (
        <div className="Login">
            <FormGroup controlId="username" bsSize="large">
                Username
                    <FormControl
                    autoFocus
                    type="username"
                    value={username}
                    onChange={e => setUsername(e.target.value)}
                />
            </FormGroup>
            <FormGroup controlId="password" bsSize="large">
                Password
                    <FormControl
                    value={password}
                    onChange={e => setPassword(e.target.value)}
                    type="password"
                />
            </FormGroup>
            <Button block bsSize="large" disabled={!validateForm()} onClick={handleSubmit} >
                Login
                </Button>
        </div>
    );
}