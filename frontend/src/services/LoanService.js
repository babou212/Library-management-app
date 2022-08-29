import axios from "axios";

const LOAN_API_BASE_URL = "http://localhost:8080/api/v1/loans/";

class LoanService {
    getAllLoans() {
        return axios.get(LOAN_API_BASE_URL + "all");
    }

    getLoanById(id) {
        const urlId = `${id}`;
        return axios.get(LOAN_API_BASE_URL + urlId);
    }

    createLoan(userId, itemId) {
        const urlId = `create-new-loan/${userId}/${itemId}`;
        return axios.post(LOAN_API_BASE_URL + urlId);
    }

    renewLoan(id) {
        const urlId = `renew-loan-with-loan-id/${id}`;
        return axios.put(LOAN_API_BASE_URL + urlId);
    }

    returnLoan(id) {
        const urlId = `return-loan/${id}`;
        return axios.put(LOAN_API_BASE_URL+ urlId);
    }
}

export default new LoanService();
