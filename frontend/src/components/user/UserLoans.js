import React from "react";

import UserService from "../../services/UserService";
import dateFormat from "dateformat";

class DisplayUserLoans extends React.Component {

    constructor(props) {
        super(props)
        this.props.location.state = {
            user:[]
        }
    }

    componentDidMount() {
        UserService.getUserById(this.props.location.state.user.id).then((response) => {
            this.setState({ user: response.data})
        });
    }

    render() {
        return (
            <div>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td> Loan Id</td>
                            <td> Item Id</td>
                            <td> Issue Date</td>
                            <td> Due Date</td>
                            <td> Number of renews</td>
                            <td> Returned</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.user.map(
                                user => 
                                <tr key = {user.id}>
                                     <td> {user.loan.id}</td>   
                                     <td> {dateFormat(user.loan.issueDate, "mmm d, yyyy")}</td>   
                                     <td> {dateFormat(user.loan.dueDate, "mmm d, yyyy")}</td>   
                                     <td> {user.loan.numRenews}</td>
                                     <td> {String(user.loan.returned)}</td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>

            </div>
        )
    }
}

export default DisplayUserLoans;
