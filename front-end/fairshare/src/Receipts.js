import React from 'react';
import './App.css';
import axios from 'axios';
import { AuthContext } from './context/Auth';

const BACKEND_URL = 'http://localhost:8081';
const BACKEND_VM_URL = 'http://137.117.229.78:8080';
const RECEIPTS_URL = BACKEND_URL + '/receipts';

export default class Receipts extends React.Component {
  static contextType = AuthContext;


  state = {
    receipts: []
  }


  componentDidMount() {
    let value = this.context;
    console.log(value.authTokens);
    if (value.authTokens) {
      axios.get(
        RECEIPTS_URL,
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
            const receipts = response.data;
            this.setState({ receipts });
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

          <img src={require('./fsr.png')} />

          <table>
            <thead>
                <td>ID</td>
                <td>Name</td>
                <td>Date of creation</td>
                <td>Date of update</td>
            </thead>
            <tbody>
              {this.state.receipts.map(receipt => ( 
                  <tr key={receipt.id}> <td> {receipt.id} </td>
                                        <td> {receipt.name} </td>
                                        <td> {receipt.createdAt} </td>
                                        <td> {receipt.updatedAt} </td>
                  </tr>
              ))}
            </tbody>
          </table>

        </div>
      );
    } else {
      return null;
    }
  }
}