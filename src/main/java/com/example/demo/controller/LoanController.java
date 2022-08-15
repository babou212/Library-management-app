package com.example.demo.controller;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Loan;
import com.example.demo.repository.LoanRepo;
import com.example.demo.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/loan")
public class LoanController {
    private final LoanRepo loanRepo;
    private final LoanService loanService;

    @GetMapping("/all")
    public List<Loan> listAllLoans() {
        if (loanRepo.count() > 0) {
            return loanRepo.findAll();
        }else {
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
    @PostMapping("/createNewLoan")
    public @ResponseBody String createNewLoan (@RequestParam Long userId, @RequestParam Long itemId){
        loanService.issueLoan(userId, itemId);
        return "New Loan Created!";
    }
}
