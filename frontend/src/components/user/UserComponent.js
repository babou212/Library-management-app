import React from "react";

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
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td> User Id</td>
                            <td> First Name</td>
                            <td> Last Name</td>
                            <td> Email</td>
                            <td> Loan Id</td>
                            <td> Delete</td>
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
                                     <td> {user.loan.id}</td>
                                     <td>{}</td>
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
