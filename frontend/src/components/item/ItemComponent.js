import React from "react";

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

    render (){
        return (
            <div>
                <h1 className = "text-center"> Items List</h1>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td> Item Id</td>
                            <td> Author</td>
                            <td> Title</td>
                            <td> Release Year</td>
                            <td> Media Type</td>
                            <td> ISBN</td>
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
                                     <td> {item.year}</td>
                                     <td> {item.mediaType}</td>
                                     <td> {item.isbn}</td>   
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