import http from "../http-common";

const LOAN_API_BASE_URL = "http://localhost:8080/api/v1/loans/";

class LoanDataService {
    getAll() {
        return http.get(LOAN_API_BASE_URL + "all");
    }

    get(id) {
        return http.get(  LOAN_API_BASE_URL + `${id}`);
    }

    create(data) {
        return http.post(  LOAN_API_BASE_URL + "create-new-loan", data);
    }

    update(id) {
        return http.put(  LOAN_API_BASE_URL + "renew-loan-with-loan-id/"  `${id}`);
    }

    delete(id) {
        return http.delete(  LOAN_API_BASE_URL+ "return-loan/"  `${id}`);
    }
}
export default new LoanDataService();
