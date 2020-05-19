import React, { useState } from 'react';
import './App.css';
import axios from 'axios';
import { Button, FormGroup, FormControl } from "react-bootstrap";
import { useAuth } from './context/Auth';
import { Redirect } from 'react-router-dom';
import { Link } from 'react-router-dom';

const BACKEND_URL = 'http://localhost:8081';
const BACKEND_VM_URL = 'http://137.117.229.78:8080';
const LOGIN_URL = BACKEND_URL + '/login';

export default function Login() {
    const { setAuthTokens } = useAuth();

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [success, setSuccess] = useState(false);

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
            <img src={require('./fslogin.png')} />
            <br/>
            <br/>
            <FormGroup controlId="username" bsSize="large">
                <b>Username: </b>
                    <FormControl
					id="inputbox2"
                    autoFocus
                    type="username"
                    value={username}
                    onChange={e => setUsername(e.target.value)}
                />
            </FormGroup>
            <br/>
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
            <Button block bsSize="large" disabled={!validateForm()} onClick={handleSubmit} >
                Login
            </Button>
            <br/>
            <br/>
            <Link to='/register'>Not a member? Register now!.</Link>
        </div>
    );
}