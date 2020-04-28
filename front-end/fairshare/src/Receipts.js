import React, {useState, useEffect} from 'react';
import './App.css';

function Receipts() {
  
  //this will only gonna run when the component mounts
  /*
  useEffect(() => {
      fetchItems();
  },[]);
  */

  //fetching data from database
  /*
  const fetchItems = async () => {
      const data = await fetch('137.117.229.78/Receipt');

      const receipts = await data.json();
      //console.log(receipts);
  }
  */
  
  return (
    <div>
      
      <h1>Receipts</h1>
        
    </div>
  );
}

export default Receipts;
