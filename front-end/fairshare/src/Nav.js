import React from 'react';
import './App.css';
import { Link } from 'react-router-dom';

function Nav() {
  const navStyle = {
    color: 'white'    
  };

  return (
    <nav>
        <ul className="nav-links">
            <Link to='/add-receipts' style={navStyle}>
            <li>Add Receipts</li>
            </Link>
            <Link to='/receipts' style={navStyle}>
            <li>Receipts</li>
            </Link>
            <Link to='/add-items' style={navStyle}>
            <li>Add Items</li>
            </Link>
            <Link to='/items' style={navStyle}>
            <li>Items</li>
            </Link>
        </ul>
        <ul className="nav-links2">
            <Link to='/login' style={navStyle}>
                <li>LOGIN</li>
            </Link>
            <Link to='/register' style={navStyle}>
                <li>REGISTER</li>
            </Link>
        </ul>
    </nav>
  );
}

export default Nav;
