package com.example.demo.controller;

import com.example.demo.model.Loan;
import com.example.demo.repository.LoanRepo;
import com.example.demo.service.LoanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/loans")
public class LoanController {
    private final LoanRepo loanRepo;
    private final LoanService loanService;

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<List<Loan>> getLoans() {
        try {
            log.info("Executing GET request");
             List<Loan> listOfLoans = loanRepo.findAll();
            return ResponseEntity.ok(listOfLoans);
        } catch (Exception ex){
            log.error("Error executing GET request: " + ex);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Loan> returnLoanById(@PathVariable Long id) {
        try {
            log.info("Executing GET request");
            return ResponseEntity.ok(loanRepo.findById(id).get());
        } catch (Exception ex) {
            log.error("Error executing GET request: " + ex);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping( "/create-new-loan/{userId}/{itemId}")
    public ResponseEntity<HttpStatus> createNewLoan(@PathVariable String userId, @PathVariable String itemId) {
        try {
            log.info("Executing POST request");
            loanService.issueLoan(Long.valueOf(userId), Long.valueOf(itemId));
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            log.error("Error executing POST request: " + ex);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping( "/renew-loan-with-loan-id/{id}")
    public ResponseEntity<HttpStatus> renewLoan(@PathVariable Long id) {
        try {
            log.info("Executing PUT request");
            loanService.renewLoan(id);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            log.error("Error executing PUT request: " + ex);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping( "/return-loan/{id}")
    public ResponseEntity<HttpStatus> returnLoan(@PathVariable Long id) {
        try {
            log.info("Executing PUT request");
            loanService.returnLoan(id);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            log.error("Error executing POST request: " + ex);
            return ResponseEntity.internalServerError().build();
        }
    }
}
