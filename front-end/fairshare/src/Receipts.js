import React, {useState, useEffect} from 'react';
import './App.css';

function Receipts() {
  
  //this fetch will only gonna run when the component mounts
  useEffect(() => {
      fetchReceipts();
  },[]);
  
  const [receipts, setItems] = useState([]);

  //fetching data from database
  const fetchReceipts = async () => {
      const data = await fetch('137.117.229.78/Receipt');
      
      //an other database for experimentation
      //const data = await fetch('http://jsonplaceholder.typicode.com/users');

      const receipts = await data.json();
      console.log(receipts);
      setItems(receipts);
  };
  
  
  return (
    <div>
      
      <h1>Receipts</h1>

      {receipts.map(receipt => ( 
          <p key={receipt.id}>{receipt.name}</p>
      ))} 

    </div>
  );
}

export default Receipts;
