import React from "react";
import { Link } from 'react-router-dom';
import { Button } from 'react-bootstrap';
import dateFormat from "dateformat";

import ItemService from "../../services/ItemService";

class ItemComponent extends React.Component {

    constructor(props){
        super(props)
        this.state = {
            items:[]
        }
    }

    componentDidMount(){
        ItemService.getAllItems().then((response) => {
            this.setState({ items: response.data})
        });
    }

    deleteItem = (id) => {
        ItemService.deleteItemById(id).then(() => {
                this.setState({items: this.state.items.filter(item => item.id !== id)
                });
            }
        );
    };

    render (){
        return (
            <div>
                <h1 className = "text-center"> Items</h1>

                <Link to={'/create-item'}>
                     <Button variant="success"> Add Item </Button>
                </Link>

                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td> Item Id</td>
                            <td> Author</td>
                            <td> Title</td>
                            <td> Release Year</td>
                            <td> Media Type</td>
                            <td> ISBN</td>
                            <td> On Loan</td>
                        </tr>
                    </thead>
                        <tbody>
                        {
                            this.state.items.map(
                                item => 
                                <tr key = {item.id}>
                                     <td> {item.id}</td>   
                                     <td> {item.author}</td>   
                                     <td> {item.title}</td>   
                                     <td> {dateFormat(item.year, "mmm d, yyyy")}</td>
                                     <td> {item.mediaType}</td>
                                     <td> {item.isbn}</td> 
                                     <td> {String(item.loaned)}</td>

                                     <td> <button className="btn btn-outline-danger" 
                                     onClick={() => {item.loaned === false && this.deleteItem(item.id)}}> Delete</button></td>  
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        )
    }
}

export default ItemComponent;
