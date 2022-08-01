package com.example.demo.service;

import com.example.demo.model.Loan;

public interface LoanService extends CrudService<Loan, Long>{
    void issueLoan(Long userId, Long itemId);

    void renewLoan(Long loanId);
}
