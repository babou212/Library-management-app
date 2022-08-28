import axios from "axios";

const LOAN_API_BASE_URL = "http://localhost:8080/api/v1/users/";

class UserService {
    getAllUsers() {
        return axios.get(LOAN_API_BASE_URL + "all");
    }

    getUserById(id) {
        return axios.get(LOAN_API_BASE_URL + "get-user/" `${id}`);
    }

    addNewUser(user) {
        return axios.post(LOAN_API_BASE_URL + "add-new-user", user);
    }

    deleteUserById(id) {
        return axios.delete(LOAN_API_BASE_URL+ "delete-user"  `${id}`);
    }
}

export default new UserService();
