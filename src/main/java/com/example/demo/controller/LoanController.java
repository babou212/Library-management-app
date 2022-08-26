package com.example.demo.controller;

import com.example.demo.DTO.LoanDto;
import com.example.demo.model.Loan;
import com.example.demo.mapper.MapStructMapper;
import com.example.demo.repository.LoanRepo;
import com.example.demo.service.LoanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:8081")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/loans")
public class LoanController {
    private final LoanRepo loanRepo;
    private final LoanService loanService;
    private final MapStructMapper mapStructMapper;

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<List<Loan>> getLoans() {
        try {
            log.info("Executing GET request");
            return ResponseEntity.ok(loanRepo.findAll());
        } catch (Exception ex){
            log.error("Error executing GET request: " + ex);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<LoanDto> returnLoanById(@PathVariable Long id) {
        try {
            log.info("Executing GET request");
            return new ResponseEntity<>(
                    mapStructMapper.convertLoanToDto(loanRepo.findById(id).get()),
                    HttpStatus.OK
            );
        } catch (Exception ex){
            log.error("Error executing GET request: " + ex);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping( "/create-new-loan")
    public ResponseEntity<Loan> createNewLoan(@RequestBody Loan loan) {
        try {
            log.info("Executing POST request");
            loanRepo.save(loan);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            log.error("Error executing POST request: " + ex);
            return ResponseEntity.internalServerError().build();
        }
    }

    @RequestMapping( "/renew-loan-with-loan-id/{id}")
    public ResponseEntity<Void> renewLoan(@PathVariable Long id) {
        try {
            log.info("Executing POST request");
            loanService.renewLoan(id);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            log.error("Error executing POST request: " + ex);
            return ResponseEntity.internalServerError().build();
        }
    }

    @RequestMapping( "/return-loan/{id}")
    public ResponseEntity<HttpStatus> returnLoan(@PathVariable Long id) {
        try {
            log.info("Executing POST request");
            loanService.returnLoan(id);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            log.error("Error executing POST request: " + ex);
            return ResponseEntity.internalServerError().build();
        }
    }
}
