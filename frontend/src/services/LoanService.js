import axios from "axios";

const LOAN_API_BASE_URL = "http://localhost:8080/api/v1/loans/";

class LoanService {
    getAllLoans() {
        return axios.get(LOAN_API_BASE_URL + "all");
    }

    getLoanById(id) {
        return axios.get(LOAN_API_BASE_URL + `${id}`);
    }

    createLoan(userId, itemId) {
        return axios.put(LOAN_API_BASE_URL + "create-new-loan", userId, itemId);
    }

    renewLoan(id) {
        return axios.put(LOAN_API_BASE_URL + "renew-loan-with-loan-id/"  `${id}`);
    }

    removeLoan(id) {
        return axios.delete(LOAN_API_BASE_URL+ "return-loan"  `${id}`);
    }
}

export default new LoanService();
