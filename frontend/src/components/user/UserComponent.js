import React from "react";
import { Link } from 'react-router-dom';
import { Button } from 'react-bootstrap';

import UserService from "../../services/UserService";

class UserComponent extends React.Component {

    constructor(props){
        super(props)
        this.state = {
            users:[]
        }
    }

    componentDidMount(){
        UserService.getAllUsers().then((response) => {
            this.setState({ users: response.data})
        });
    }

    render (){
        return (
            <div>
                <h1 className = "text-center"> User List</h1>

                <Link to={'/add-user'}>
                     <Button variant="success"> Add user </Button>
                </Link>

                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td> User Id</td>
                            <td> First Name</td>
                            <td> Last Name</td>
                            <td> Email</td>
                            <td> Details</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.users.map(
                                user => 
                                <tr key = {user.id}>
                                     <td> {user.id}</td>   
                                     <td> {user.firstName}</td>   
                                     <td> {user.lastName}</td>   
                                     <td> {user.email}</td>
                                     <td> 
                                     <Link to={'/view-user'}>
                                        <Button variant="success"> View User</Button>
                                     </Link>
                                     </td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        )
    }
}

export default UserComponent;
