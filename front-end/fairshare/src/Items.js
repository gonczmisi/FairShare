import React, {useState, useEffect} from 'react';
import './App.css';
import axios from 'axios';

const BACKEND_URL = 'http://localhost:8081';
const BACKEND_VM_URL = 'http://137.117.229.78:8080';
const ITEMS_URL = BACKEND_URL + '/items';

export default class Items extends React.Component {

  state = {
    items: []
  }

  /*
  componentDidMount() {
    axios.get(ITEMS_URL)
      .then(response => {
        const items = response.data;
        this.setState({ items });
      })
  }
  */

  render(){
    return (
      <div>
        
        <h1>Items</h1>

        <table>
            <thead></thead>
            <tbody></tbody>
        </table>
          
      </div>
    );
  }
}
