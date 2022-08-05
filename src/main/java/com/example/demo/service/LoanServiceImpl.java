package com.example.demo.service;

import com.example.demo.model.Item;
import com.example.demo.model.Loan;
import com.example.demo.model.MediaType;
import com.example.demo.model.User;
import com.example.demo.repository.LoanRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class LoanServiceImpl implements LoanService {
    private final LoanRepo loanRepo;
    private final User user;
    private final Item item;
    private final Loan loan;

    @Override
    public void issueLoan(Long userId, Long itemId) {
        if (user.getUserId().equals(userId) && item.getItemId().equals(itemId)) {
            LocalDate issueDate = LocalDate.now();
            LocalDate currentDate = LocalDate.now();
            int numRenews = 0;

            if(item.getMediaType().equals(MediaType.BOOK)) {
                LocalDate dueDate = currentDate.plus(4, ChronoUnit.WEEKS);
                Loan.builder().issueDate(issueDate).dueDate(dueDate).numRenews(numRenews);
                loanRepo.save(loan);
            } else if (item.getMediaType().equals(MediaType.MULTIMEDIA)){
                LocalDate dueDate = currentDate.plus(1, ChronoUnit.WEEKS);
                Loan.builder().issueDate(issueDate).dueDate(dueDate).numRenews(numRenews);
                loanRepo.save(loan);
            }
        }
    }

    @Override
    public void renewLoan(Long loanId) {
        if (loan.getLoanId().equals(loanId)) {
            LocalDate currentDate = LocalDate.now();

                if (loan.getItem().getMediaType().equals(MediaType.BOOK)
                        && loan.getNumRenews() < 3) {
                    LocalDate dueDate = currentDate.plus(2, ChronoUnit.WEEKS);
                    loan.setDueDate(dueDate);
                    loan.setNumRenews(loan.getNumRenews() + 1);
                } else if (loan.getItem().getMediaType().equals(MediaType.MULTIMEDIA) &&
                        loan.getNumRenews() < 2) {
                    LocalDate dueDate = currentDate.plus(1, ChronoUnit.WEEKS);
                    loan.setDueDate(dueDate);
                    loan.setNumRenews(loan.getNumRenews() + 1);
                }
        }
    }

    @Override
    public Set<Loan> findAll() {
        return (Set<Loan>) loanRepo.findAll();
    }

    @Override
    public Loan findById(Long aLong) {
        return loanRepo.findById(aLong).orElse(null);
    }

    @Override
    public Loan save(Loan object) {
        return loanRepo.save(object);
    }

    @Override
    public void delete(Loan object) {
        loanRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        LocalDate currentDate = LocalDate.now();

        if (loan.getLoanId().equals(aLong)) {
            if (loan.getDueDate().isAfter(currentDate) || loan.getDueDate().equals(currentDate)) {
                loanRepo.deleteById(aLong);
            }
        }
    }
}
