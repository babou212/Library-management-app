import React from 'react';

import UserAddress from "./UserAddress";
import UserLoans from "./UserLoans";
import UserDetails from "./UserDetails";

function viewUserDetails() {
    return (
        <div>
            <UserDetails />
            <UserAddress />
            <UserLoans />
        </div>
    );
}

export default viewUserDetails;
