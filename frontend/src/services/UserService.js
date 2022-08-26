import http from "../http-common";

const LOAN_API_BASE_URL = "http://localhost:8080/api/v1/users/";

class UserDataService {
    getAll() {
        return http.get(LOAN_API_BASE_URL + "all");
    }

    get(id) {
        return http.get(  LOAN_API_BASE_URL + `${id}`);
    }

    create(data) {
        return http.post(  LOAN_API_BASE_URL + "add-new-user", data);
    }

    update(id) {
        return http.put(  LOAN_API_BASE_URL + ""  `${id}`);
    }

    delete(id) {
        return http.delete(  LOAN_API_BASE_URL+ "delete-user"  `${id}`);
    }
}
export default new UserDataService();
