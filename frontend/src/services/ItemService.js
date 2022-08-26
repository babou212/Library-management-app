import http from "../http-common";

const LOAN_API_BASE_URL = "http://localhost:8080/api/v1/items/";

class ItemDataService {
    getAll() {
        return http.get(LOAN_API_BASE_URL + "all");
    }

    get(id) {
        return http.get(  LOAN_API_BASE_URL + `${id}`);
    }

    create(data) {
        return http.post(  LOAN_API_BASE_URL + "add-new-item", data);
    }

    delete(id) {
        return http.delete(  LOAN_API_BASE_URL+ "delete-item"  `${id}`);
    }
}
export default new ItemDataService();
