import http from "../http-common";

const LOAN_API_BASE_URL = "http://localhost:8080/api/v1/loans/";

class LoanDataService {
    getAllLoans() {
        return http.get(LOAN_API_BASE_URL + "all");
    }

    getLoanById(id) {
        return http.get(  LOAN_API_BASE_URL + `${id}`);
    }

    createLoan(userId, itemId) {
        return http.put(  LOAN_API_BASE_URL + "create-new-loan", userId, itemId);
    }

    renewLoan(id) {
        return http.put(  LOAN_API_BASE_URL + "renew-loan-with-loan-id/"  `${id}`);
    }

    removeLoan(id) {
        return http.delete(  LOAN_API_BASE_URL+ "return-loan"  `${id}`);
    }
}

export default new LoanDataService();
