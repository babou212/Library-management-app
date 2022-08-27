import http from "../http-common";

const LOAN_API_BASE_URL = "http://localhost:8080/api/v1/users/";

class UserDataService {
    getAllUsers() {
        return http.get(LOAN_API_BASE_URL + "all");
    }

    addNewUser(data) {
        return http.post(  LOAN_API_BASE_URL + "add-new-user", data);
    }

    deleteUserById(id) {
        return http.delete(  LOAN_API_BASE_URL+ "delete-user"  `${id}`);
    }
}

export default new UserDataService();
