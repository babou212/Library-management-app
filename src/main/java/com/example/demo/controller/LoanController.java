package com.example.demo.controller;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Loan;
import com.example.demo.repository.LoanRepo;
import com.example.demo.service.LoanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/loan")
public class LoanController {
    private final LoanRepo loanRepo;
    private final LoanService loanService;

    @GetMapping("/all")
    public @ResponseBody Optional<List<Loan>> listAllLoans() {
        if (loanRepo.count() > 0) {
            return Optional.of(loanRepo.findAll());
        } else {
            throw new NotFoundException("No Loans Found");
        }
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Loan> returnLoanById(@PathVariable(name = "id") Long id) {
        if (loanRepo.existsById(id)) {
            return loanRepo.findById(id);
        } else {
            throw new NotFoundException("Loan Not Found");
        }
    }

    @RequestMapping("/create-new-loan/{userId}/{itemId}")
    public void createNewLoan(@PathVariable Long userId, @PathVariable Long itemId) {
        try {
            loanService.issueLoan(userId, itemId);

        } catch (NumberFormatException e) {
            log.error("Null value passed " + e);
        }
    }

    @RequestMapping("/renew-loan-with-loan-id/{loanId}")
    public void renewLoan(@PathVariable Long loanId) {
        try {
            loanService.renewLoan(loanId);

        } catch (NumberFormatException e) {
            log.error("Null value passed " + e);
        }
    }
}
