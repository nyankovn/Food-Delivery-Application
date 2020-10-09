import React, { Component } from "react";
import AdminService from "../services/AdminService";

class ListAdminComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      admins: [],
    };
  }

  componentDidMount() {
    AdminService.getAdmins().then((res) => {
      this.setState({ admins: res.data });
    });
  }
  render() {
    return (
      <div>
        <h2 className="text-center">Admins list</h2>
        <div className="row"></div>
        <table className="table table-striped table-borde">
          <thead>
            <tr>
              <th>ID</th>
              <th>First name</th>
              <th>Last name</th>
              <th>Email</th>
              <th>Phone number</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {this.state.admins.map((admin) => (
              <tr key={admin.id}>
                <td>{admin.id}</td>
                <td>{admin.firstName}</td>
                <td>{admin.lastName}</td>
                <td>{admin.email}</td>
                <td>{admin.phoneNumber}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default ListAdminComponent;
