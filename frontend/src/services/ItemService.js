import axios from "axios";

const LOAN_API_BASE_URL = "http://localhost:8080/api/v1/items/";

class ItemDataService {
    getAllItems() {
        return axios.get(LOAN_API_BASE_URL + "all");
    }

    getItemById(id) { 
        return axios.get(LOAN_API_BASE_URL + "get-item/" `${id}`);
    }

    createNewItem(author, title, release, mediaType, isbn) {
        const url = `add-new-item/${author}/${title}/${release}/${mediaType}/${isbn}`;
        return axios.post( LOAN_API_BASE_URL + url);
    }

    deleteItemById(id) {
        const urlId = `delete-item/${id}`;
        return axios.delete(LOAN_API_BASE_URL+ urlId);
    }
}
export default new ItemDataService();
