import axios from "axios";

const LOAN_API_BASE_URL = "http://localhost:8080/api/v1/users/";

class UserService {
    getAllUsers() {
        return axios.get(LOAN_API_BASE_URL + "all");
    }

    addNewUser(data) {
        return axios.post(LOAN_API_BASE_URL + "add-new-user", data);
    }

    deleteUserById(id) {
        return axios.delete(LOAN_API_BASE_URL+ "delete-user"  `${id}`);
    }
}

export default new UserService();
