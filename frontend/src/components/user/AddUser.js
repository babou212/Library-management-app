import React, { useState } from "react";
import { Button, Form } from 'react-bootstrap';

import UserService from "../../services/UserService";

function AddLoans() {
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    
    return (
          <Form onSubmit={createNewUserHandler}>
          <Form.Group role="form">
            
            <Form.Label></Form.Label>
            <Form.Control  
            type="text"
            value={firstName}
            placeholder="First Name"
            onChange={(event) => setFirstName(event.target.value)}
            />

            <Form.Label></Form.Label>
            <Form.Control  
            type="text"
            value={lastName}
            placeholder="Last Name"
            onChange={(event) => setLastName(event.target.value)}
            />  

            <Form.Label></Form.Label>
            <Form.Text>
                Please enter valid email
            </Form.Text>
            <Form.Control  
            type="text"
            value={email}
            placeholder="Email"
            onChange={(event) => setEmail(event.target.value)}
            />  

            <Button  variant="success" type="submit">Submit</Button>
        </Form.Group>
        </Form>
      );

      function createNewUserHandler(event) {
        event.preventDefault();

        UserService.addNewUser(firstName, lastName, email)
        .then(res => console.log("Executing POST request", res)).catch(err => console.log(err))
    };
}

export default AddLoans;
