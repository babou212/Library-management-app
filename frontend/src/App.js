import {Component} from "react";
import { BrowserRouter as Router, Route, Routes, Link} from "react-router-dom";

import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";

import Loan from "./components/loan/Loan";
import AddLoan from "./components/loan/AddLoan";
import ListLoan from "./components/loan/Listloan";

class App extends Component {
  render() {
    return (
        <Router>
        <div>
          <nav className="navbar navbar-expand navbar-dark bg-dark">
            <a href="/tutorials" className="navbar-brand">
              Library management System
            </a>
            <div className="navbar-nav mr-auto">
              <li className="nav-item">
                <Link to={"/v1/loans/all"} className="nav-link">
                  Loans
                </Link>
              </li>
              <li className="nav-item">
                <Link to={"/add"} className="nav-link">
                  Add
                </Link>
              </li>
            </div>
          </nav>
          <div className="container mt-3">
            <Routes>
              <Route exact path={["/v1", "/loans/all"]} component={ListLoan} />
              <Route exact path="/v1/create-new-loan" component={AddLoan} />
              <Route path="/v1/loans/:id" component={Loan} />
            </Routes>
          </div>
        </div>
        </Router>
    );
  }
}

export default App;
