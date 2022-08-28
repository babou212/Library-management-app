import React from "react";

import LoanService from "../../services/LoanService";

class LoanComponent extends React.Component {

    constructor(props){
        super(props)
        this.state = {
            loans:[]
        }
    }

    componentDidMount(){
        LoanService.getAllLoans().then((response) => {
            this.setState({ loans: response.data})
        });
    }

    returnLoan = (id) => {
        LoanService.returnLoan(id).then(() => {
                this.setState({loans: this.state.loans.filter(loan => loan.id !== id)
                });
            }
        );
    };

    render (){
        return (
            <div>
                <h1 className = "text-center"> Loans List</h1>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td> Loan Id</td>
                            <td> Item Id</td>
                            <td> User Id</td>
                            <td> Issue Date</td>
                            <td> Due Date</td>
                            <td> Number of renews</td>
                            <td> Returned</td>
                            <td> Actions</td>
                        </tr>

                    </thead>
                    <tbody>
                        {
                            this.state.loans.map(
                                loan => 
                                <tr key = {loan.id}>
                                     <td> {loan.id}</td>   
                                     <td> {loan.item.id}</td>   
                                     <td> {loan.libraryUser.id}</td>   
                                     <td> {loan.issueDate}</td>
                                     <td> {loan.dueDate}</td>
                                     <td> {loan.numRenews}</td>
                                     <td> {String(loan.returned)}</td>
                                     <td> <button className="btn btn-outline-danger" 
                                     onClick={() => {this.returnLoan(loan.id)}}> Return</button></td>   
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        )
    }
}

export default LoanComponent;
