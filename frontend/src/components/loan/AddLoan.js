import React, { useState } from "react";
import { Button, Form } from 'react-bootstrap';

import LoanService from "../../services/LoanService";

function AddLoans() {
    const [userId, setUserId] = useState("");
    const [itemId, SetItemId] = useState("");

    return (
          <Form onSubmit={issueLoanHandler}>
          <Form.Group role="form">
            
            <Form.Label></Form.Label>
            <Form.Control  
            type="text"
            value={userId}
            placeholder="User Id"
            onChange={(event) => setUserId(event.target.value)}
            />

            <Form.Label></Form.Label>
            <Form.Control  
            type="text"
            value={itemId}
            placeholder="Item Id"
            onChange={(event) => SetItemId(event.target.value)}
            />  
            
            <Button  variant="success" type="submit">Submit</Button>
        </Form.Group>
        </Form>
      );

      function issueLoanHandler(event) {
        event.preventDefault();
        LoanService.createLoan(userId, itemId)
        .then(res => console.log("Executing POST request", res)).catch(err => console.log(err))
    };
}

export default AddLoans;
