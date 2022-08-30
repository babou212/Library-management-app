import axios from "axios";

const LOAN_API_BASE_URL = "http://localhost:8080/api/v1/users/";

class UserService {
    getAllUsers() {
        return axios.get(LOAN_API_BASE_URL + "all");
    }

    getUserById(id) {
        const url = `get-user/${id}`;
        return axios.get(LOAN_API_BASE_URL + url);
    }

    addNewUser(firstName, lastName, email) {
        const url = `create-new-user/${firstName}/${lastName}/${email}`;
        return axios.post(LOAN_API_BASE_URL + url);
    }

    deleteUserById(id) {
        const urlId = `delete-user/${id}`;
        return axios.delete(LOAN_API_BASE_URL+ urlId);
    }
}

export default new UserService();
