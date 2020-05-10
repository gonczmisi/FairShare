import React from 'react';
import './App.css';

class Register extends React.Component
{
    constructor(props)
    {
        super(props);

        this.state =
        {
            id: '',
            created_at: '',
            updated_at: '',
            username: '',
            password: '',
            email_address: '',
            user_role: '',
            success: null,
        };
    }


    render()
    {
        return (
            <div>
                <h1>Registration</h1>
                <p>
                    Please fill in all the required fields to create a new user account.
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
                    <div className="form-group">
                        <label>First Name:      </label>
                        <input type="text" className="form-control" placeholder="First Name" name="firstName" />
                    </div>
                    <br></br>
                    <br></br>
                    <div className="form-group">
                        <label>Last Name:      </label>
                        <input type="text" className="form-control" placeholder="Last Name" name="lastName"  />
                    </div>
                    <br></br>
                    <br></br>
                                                           
                    <button type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        );
    }
 }

export default Register;