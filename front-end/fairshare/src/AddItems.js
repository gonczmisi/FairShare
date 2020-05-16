import React from 'react';
import './App.css';


class AddItems extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
          id: 1,
          created_at: '',
          updated_at: '',
          name: '',
          price: null,
          currency_type: 'HUF',
          
          date: new Date(),
          options: { year: 'numeric', month: 'long', day: 'numeric', hour: 'numeric',  minute: 'numeric'},
        };
        
        this.handleTxtChange = this.handleTxtChange.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleTxtChange(event) {
      let name = event.target.name;
      let value = event.target.value;
      this.setState({[name]: value});
    }

    handleChange(event) {
      this.setState({currency_type: event.target.value});
    }

    handleSubmit(event) {
      event.preventDefault();
      this.setState({id: this.state.id+1});

      var tmp_date = this.state.date.toLocaleDateString('en-GB', this.state.options);
      this.setState({created_at: tmp_date});
      this.setState({updated_at: tmp_date});
      this.setState({name: event.target.name});
      this.setState({price: event.target.price});
      
      this.setState({name: ''});
      this.setState({price: null});
    }  

    
    render() {
        return (
            <div>
                <h1>Add Items</h1>
                <p> Fill out the fields to add an item! </p>
                <br></br>
                
                <form onSubmit={this.handleSubmit}>
                    <div className="form-group">
                        <label>Item name:</label>
                        <input type="text" className="form-control" placeholder="Item name" name="name" required onChange={this.handleTxtChange}/>
                    </div>
                    <br></br>
                    <br></br>
                    <div className="form-group">
                        <label>Price:</label>
                        <input type="number" className="form-control" placeholder="Price" name="price" required onChange={this.handleTxtChange}/>
                    </div>
                    <br></br>
                    <br></br>
                    <div className="form-group">
                    <label>Currency Type:
                        <select value={this.state.currency_type} onChange={this.handleChange}>
                            <option currency_type="HUF">[HUF] Hungarian Forint</option>
                            <option currency_type="USD">[USD] American Dollar</option>
                            <option currency_type="EUR">[EUR] Euro</option>
                        </select>
                    </label> 
                    </div>
                    <br></br>
                    <br></br>                 
                                       
                    <button type="submit" className="btn btn-primary">ADD</button>
                </form>
            </div>
        );
    }
 }

export default AddItems;
