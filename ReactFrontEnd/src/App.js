import React from "react";
import logo from "./logo.svg";
import "./App.css";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import ListAdminComponent from "./components/ListAdminComponent";
import AdminUIHeaderComponent from "./components/AdminUIHeaderComponent";
import AdminUIFooterComponent from "./components/AdminUIFooterComponent";

function App() {
  return (
    <div>
      <Router>
        <AdminUIHeaderComponent />
        <div className="container">
          <Switch>
            <Route path="/" component={ListAdminComponent}></Route>
            <Route path="/admins" component={ListAdminComponent}></Route>
            <ListAdminComponent />
          </Switch>
        </div>
        <AdminUIFooterComponent />
      </Router>
    </div>
  );
}

export default App;
