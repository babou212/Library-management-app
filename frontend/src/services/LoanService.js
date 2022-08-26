import http from "../http-common";
class LoanDataService {
    getAll() {
        return http.get("/v1/loans/all");
    }
    get(id) {
        return http.get(`/v1/loans/${id}`);
    }
    create(data) {
        return http.post("/v1/loans/create-new-loan", data);
    }
    update(id) {
        return http.put(`/v1/loans//renew-loan-with-loan-id/${id}`);
    }
    delete(id) {
        return http.delete(`/v1/loans/return-loan${id}`);
    }
}
export default new LoanDataService();
