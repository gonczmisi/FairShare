import React, {useState, useEffect} from 'react';
import './App.css';
import { Link } from 'react-router-dom';

function Items() {

  //this fetch will only gonna run when the component mounts
  useEffect(() => {
    fetchReceipts();
  },[]);

  const [items, setItems] = useState([]);

  //fetching data from database
  const fetchReceipts = async () => {
     const data = await fetch('137.117.229.78/Item');
     
     //an other database for experimentation 
     //const data = await fetch('http://jsonplaceholder.typicode.com/users');

      const items = await data.json();
      console.log(items);
      setItems(items);
  };


  return (
    <div>
      
      <h1>Items</h1>

      {items.map(item => ( 
          <p key={item.id}>{item.name}</p>
      ))} 
        
    </div>
  );
}

export default Items;
