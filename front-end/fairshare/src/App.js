import React from 'react';
import './App.css';
import Nav from './Nav';
import AddReceipts from './AddReceipts';
import Receipts from './Receipts';
import AddItems from './AddItems';
import Items from './Items';
import Login from './Login';
import Register from './Register';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';

function App() {
  return (
    <Router>
      <div className="App">
        <Nav />
        <Switch>
          <Route path="/" exact component={Home} />
          <Route path="/add-receipts" component={AddReceipts} />
          <Route path="/receipts" component={Receipts} />
          <Route path="/add-items" component={AddItems} />
          <Route path="/items" component={Items} />
          <Route path="/login" component={Login} />
          <Route path="/register" component={Register} />
        </Switch>
      </div>
    </Router>
  );
}

const Home = () => (
  <div>
    <h1> FairShare </h1>
    <a className="App-link" href="https://github.com/gonczmisi/FairShare" target="_blank" rel="noopener noreferrer"> Learn more about this app. </a>
  </div>
)

export default App;
