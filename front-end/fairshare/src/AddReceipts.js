import React from 'react';
import './App.css';


class AddReceipts extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
          id: 1,
          created_at: '',
          updated_at: '',
          name: '',
          
          date: new Date(),
          options: { year: 'numeric', month: 'long', day: 'numeric', hour: 'numeric',  minute: 'numeric'},
        };
        
        this.handleTxtChange = this.handleTxtChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleTxtChange(event) {
      let name = event.target.name;
      let value = event.target.value;
      this.setState({[name]: value});
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
                <h1>Add Recepits</h1>
                <p> Fill out the fields to add a receipt! </p>
                <br></br>
                
                <form onSubmit={this.handleSubmit}>
                    <div className="form-group">
                        <label>Recepit name:</label>
                        <input type="text" className="form-control" placeholder="Receipt name" name="name" required onChange={this.handleTxtChange}/>
                    </div>
                    <br></br>
                    <br></br>
                    <p>select items [to be added]</p>                 
                                       
                    <button type="submit" className="btn btn-primary">ADD</button>
                </form>
            </div>
        );
    }
 }

export default AddReceipts;
