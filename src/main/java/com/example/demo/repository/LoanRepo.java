package com.example.demo.repository;

import com.example.demo.model.Loan;
import org.springframework.data.repository.CrudRepository;

public interface LoanRepo extends CrudRepository<Loan, Long> {
}