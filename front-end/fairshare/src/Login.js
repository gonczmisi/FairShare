import React, { useState } from 'react';
import './App.css';
import axios from 'axios';
import { useAuth } from './context/Auth';

const BACKEND_URL = 'http://localhost:8080';
const BACKEND_VM_URL = 'http://137.117.229.78:8080';
const USER_URL = BACKEND_URL + '/user';
const LOGIN_URL = BACKEND_URL + '/login';

export default function Login() {
    const { setAuthTokens } = useAuth();
    
    const [id, setId] = useState();
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();
    const [email, setEmail] = useState();
    const [success, setSuccess] = useState(null);

    function handleClick(event) {
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
                } else{
                    setSuccess(false);
                }
            })
            .catch(error => {
                console.log(error);
                setSuccess(false);
            });
    };

    return (
        <div>
            <h1>Login</h1>
            <p>
                Please fill out the required fields to log in!
                </p>
            <br></br>

            <form onSubmit={handleClick}>
                <div className="form-group">
                    <label>Username:      </label>
                    <input type="text" className="form-control" placeholder="Username" name="username" required />
                </div>
                <br></br>
                <br></br>
                <div className="form-group">
                    <label>E-Mail Address:      </label>
                    <input type="text" className="form-control" placeholder="E-Mail Address" name="username" required />
                </div>
                <br></br>
                <br></br>
                <div className="form-group">
                    <label>Password:      </label>
                    <input type="password" className="form-control" placeholder="Password" name="newPassword" required />
                </div>
                <br></br>
                <br></br>

                <button type="submit" className="btn btn-primary">Login</button>
            </form>
        </div>
    );
}