import React from 'react';
import './App.css';

class Login extends React.Component
{
    constructor(props)
    {
        super(props);

        this.state =
        {
            id: '',
            username: '',
            password: '',
            email_address: '',
            success: null,
        };
    }

    
    render()
    {
        return (
            <div>
                <h1>Login</h1>
                <p>
                    Please fill out the required fields to log in!
                </p>
                <br></br>
                
                <form onSubmit={this.handleSubmit}>
                    <div className="form-group">
                        <label>Username:      </label>
                        <input type="text" className="form-control" placeholder="Username" name="username" required />
                    </div>
                    <br></br>
                    <br></br>
                    <div className="form-group">
                        <label>E-Mail Address:      </label>
                        <input type="text" className="form-control" placeholder="E-Mail Address" name="username" required />
                    </div>
                    <br></br>
                    <br></br>
                    <div className="form-group">
                        <label>Password:      </label>
                        <input type="password" className="form-control" placeholder="Password" name="newPassword" required />
                    </div>
                    <br></br>
                    <br></br>                 
                                       
                    <button type="submit" className="btn btn-primary">Login</button>
                </form>
            </div>
        );
    }
 }

export default Login;