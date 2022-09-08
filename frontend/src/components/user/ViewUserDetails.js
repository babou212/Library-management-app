import React from 'react';

import UserAddress from "./UserAddress";
import UserLoans from "./UserLoans";
import UserDetails from "./UserDetails";

function viewUserDetails() {
    return (
        <div>
            <h1 className = "text-center">User details</h1>
            {/* <UserDetails />
            <UserAddress /> */}
            <UserLoans />
        </div>
    );
}

export default viewUserDetails;
