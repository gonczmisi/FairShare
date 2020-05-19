import React from 'react';
import './App.css';
import { Link } from 'react-router-dom';
import { Form, Button, FormGroup, FormControl } from "react-bootstrap";
import { Redirect } from 'react-router-dom';

function Nav() {
  const navStyle = {
    color: 'white'    
  };

  return (
    <nav>
        <ul className="nav-links">
        <Link to='/receipts' style={navStyle}>
            <Button block bsSize="Extra-large"  id="button2">
                Receipts
            </Button>
            </Link>
            <Link to='/add-receipts' style={navStyle}>
            <Button block bsSize="Extra-large"  id="button2">
                Add Receipts
            </Button>
            </Link>
            <Link to='/items' style={navStyle}>
            <Button block bsSize="Extra-large"  id="button2">
                Items
            </Button>
            </Link>
            <Link to='/add-items' style={navStyle}>
            <Button block bsSize="Extra-large"  id="button2">
                Add Items
            </Button>
            </Link>
        </ul>
        <ul className="nav-links2">
            <Link to='/login' style={navStyle}>
                <Button block bsSize="Extra-large"  id="button2">
                Login
            </Button>
            </Link>
            <Link to='/register' style={navStyle}>
                <Button block bsSize="Extra-large"  id="button2">
                Register
            </Button>
            </Link>
        </ul>
    </nav>
  );
}

export default Nav;
