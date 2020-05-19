import React from 'react';
import './App.css';
import axios from 'axios';
import { AuthContext } from './context/Auth';

const BACKEND_URL = 'http://localhost:8081';
const BACKEND_VM_URL = 'http://137.117.229.78:8080';
const ITEMS_URL = BACKEND_URL + '/items';

export default class Items extends React.Component {
  static contextType = AuthContext;

  state = {
    items: []
  }


  componentDidMount() {
    let value = this.context;
    console.log(value.authTokens);
    if (value.authTokens) {
      axios.get(
        ITEMS_URL,
        {
          auth: {
            username: value.authTokens.username,
            password: value.authTokens.password
          }
        }
      )
        .then(response => {
          if (response.status === 200) {
            console.log(response.data);
            const items = response.data;
            this.setState({ items });
          } else {
            console.log("ERROR");
            alert("Error!");
          }
        })
        .catch(error => {
          console.log(error);
          alert("Error!");
        });
    }
  }


  render() {
    if (this.context) {
      return (
        <div>

          <img src={require('./FSI.png')} />

          <table>
            <thead></thead>
            <tbody></tbody>
          </table>

        </div>
      );
    } else {
      return null;
    }
  }
}
