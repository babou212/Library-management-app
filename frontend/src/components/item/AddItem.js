import React, { useState } from "react";
import { Button, Form } from 'react-bootstrap';

import ItemService from "../../services/ItemService";

function AddLoans() {
    const [author, setAuthor] = useState("");
    const [title, setTitle] = useState("");
    const [release, setRelease] = useState("");
    const [mediaType, setMediaType] = useState("");
    const [isbn, setIsbn] = useState("");

    return (
          <Form onSubmit={createNewItemHandler}>
          <Form.Group role="form">
            
            <Form.Label></Form.Label>
            <Form.Control  
            type="text"
            value={author}
            placeholder="Author"
            onChange={(event) => setAuthor(event.target.value)}
            />

            <Form.Label></Form.Label>
            <Form.Control  
            type="text"
            value={title}
            placeholder="Title"
            onChange={(event) => setTitle(event.target.value)}
            />  

            <Form.Label></Form.Label>
            <Form.Text>
                Please enter in format yyyy-mm-dd
            </Form.Text>
            <Form.Control  
            type="text"
            value={release}
            placeholder="Release"
            onChange={(event) => setRelease(event.target.value)}
            />  

            <Form.Label></Form.Label>
            <Form.Control  
            type="text"
            value={mediaType}
            placeholder="Media Type"
            onChange={(event) => setMediaType(event.target.value)}
            />  

            <Form.Label></Form.Label>
            <Form.Control  
            type="text"
            value={isbn}
            placeholder="ISBN"
            onChange={(event) => setIsbn(event.target.value)}
            />  
            
            <Button  variant="success" type="submit">Submit</Button>
        </Form.Group>
        </Form>
      );

      function createNewItemHandler(event) {
        event.preventDefault();

        ItemService.createNewItem(author, title, release, mediaType, isbn)
        .then(res => console.log("Executing POST request", res)).catch(err => console.log(err))
    };
}

export default AddLoans;
