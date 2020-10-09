import axios from "axios";

const ADMIN_API_BASE_URL = "http://localhost:8090/foodDelivery/admins";

class AdminService {
  getAdmins() {
    return axios.get(ADMIN_API_BASE_URL);
  }
}

export default new AdminService();
