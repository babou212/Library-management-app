import http from "../http-common";

const LOAN_API_BASE_URL = "http://localhost:8080/api/v1/items/";

class ItemDataService {
    getAllItems() {
        return http.get(LOAN_API_BASE_URL + "all");
    }

    createNewItem(data) {
        return http.post(  LOAN_API_BASE_URL + "add-new-item", data);
    }

    deleteItemById(id) {
        return http.delete(  LOAN_API_BASE_URL+ "delete-item"  `${id}`);
    }
}
export default new ItemDataService();
