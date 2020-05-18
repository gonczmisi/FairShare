import React, {useState, useEffect} from 'react';
import './App.css';
import axios from 'axios';

const BACKEND_URL = 'http://localhost:8081';
const BACKEND_VM_URL = 'http://137.117.229.78:8080';
const RECEIPTS_URL = BACKEND_URL + '/receipts';

export default class Receipts extends React.Component {
  
  state = {
    receipts: []
  }
    
  /*
  componentDidMount() {
    axios.get(RECEIPTS_URL)
      .then(response => {
        const receipts = response.data;
        this.setState({ receipts });
      })
  }
  */
 
  render(){
    return (
      <div>
        
        <h1>Receipts</h1>

        <table>
            <thead></thead>
            <tbody></tbody>
        </table>

      </div>
    );
  }
}