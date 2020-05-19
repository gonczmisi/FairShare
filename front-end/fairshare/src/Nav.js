import React, { useState } from 'react';
import './App.css';
import { Link } from 'react-router-dom';
import { Button } from "react-bootstrap";
import { useAuth } from './context/Auth';
import { Redirect } from 'react-router-dom';

function Nav() {
    const { setAuthTokens, authTokens } = useAuth();

    const navStyle = {
        color: 'white'
    };

    const singOut = () => {
        setAuthTokens();
    }

    if(!authTokens){
        return <Redirect to="/login" />
    }

    return (
        <nav>
            <ul className="nav-links">
                {authTokens &&
                    <>
                        <Link to='/receipts' style={navStyle}>
                            <Button block bsSize="Extra-large" id="button2">
                                Receipts
                        </Button>
                        </Link>
                        <Link to='/add-receipts' style={navStyle}>
                            <Button block bsSize="Extra-large" id="button2">
                                Add Receipts
                        </Button>
                        </Link>
                        <Link to='/items' style={navStyle}>
                            <Button block bsSize="Extra-large" id="button2">
                                Items
                        </Button>
                        </Link>
                        <Link to='/add-items' style={navStyle}>
                            <Button block bsSize="Extra-large" id="button2">
                                Add Items
                        </Button>
                        </Link>
                    </>
                }
            </ul>

            <ul className="nav-links2">
                {!authTokens &&
                    <>
                        <Link to='/login' style={navStyle}>
                            <Button block bsSize="Extra-large" id="button2">
                                Login
                            </Button>
                        </Link>
                        <Link to='/register' style={navStyle}>
                            <Button block bsSize="Extra-large" id="button2">
                                Register
                            </Button>
                        </Link>
                    </>
                }
                {authTokens &&
                    <Button
                        id="button2"
                        variant='text'
                        color='primary'
                        onClick={singOut}
                    >
                        Signout
                    </Button>
                }

            </ul>
        </nav>
    );
}

export default Nav;
