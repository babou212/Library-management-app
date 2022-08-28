import React from "react";
import { Route, Routes } from "react-router-dom";

import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";

import NavBar from "./NavBar";
import Footer from "./components/footer/Footer";
import Home from "./components/Home/Home";
import Loan from "./components/loan/LoanComponent";
import Item from "./components/item/Item";
import User from "./components/user/User";

function App()  {

  return (
      <>
      <NavBar />
        <div className="container">
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/loans" element={<Loan />} />
                <Route path="/items" element={<Item />} />
                <Route path="/users" element={<User />} />
            </Routes>
        </div>
        <Footer /> 
      </>
  )
}

export default App;
