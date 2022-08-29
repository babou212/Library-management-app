import React, { useState } from "react";

import LoanService from "../../services/LoanService";

function AddLoans() {
    const [userId, setUserId] = useState("");
    const [itemId, SetItemId] = useState("");

    return (
        <div >
          <form onSubmit={issueLoanHandler}>
            <input
              type="text"
              value={userId}
              placeholder="User Id"
              onChange={(event) => setUserId(event.target.value)}
            />

            <input
              type="text"
              value={itemId}
              placeholder="Item Id"
              onChange={(event) => SetItemId(event.target.value)}
            />
            
            <button type="submit">Issue Loan</button>
    
          </form>
        </div>
      );

      function issueLoanHandler(event) {
        event.preventDefault();
        LoanService.createLoan(userId, itemId)
        .then(res => console.log("Executing POST request", res)).catch(err => console.log(err))
    };
}

export default AddLoans;
