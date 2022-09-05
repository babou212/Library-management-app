package com.example.demo.service;

import com.example.demo.model.Item;
import com.example.demo.model.Loan;
import com.example.demo.model.MediaType;
import com.example.demo.model.LibraryUser;
import com.example.demo.repository.ItemRepo;
import com.example.demo.repository.LoanRepo;
import com.example.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoanService {
    private final LoanRepo loanRepo;

    private final UserRepo userRepo;

    private final ItemRepo itemRepo;

    public void issueLoan(Long userId, Long itemId) {
        LocalDate issueDate = LocalDate.now();
        LocalDate currentDate = LocalDate.now();
        int numRenews = 0;

            LibraryUser filteredUser = userRepo.findAll().stream().filter(user -> user.getId().equals(userId))
                    .reduce((a, b) -> {
                        throw new IllegalStateException("Multiple elements: " + a + ", " + b);
                    }).get();

            Item filteredItem = itemRepo.findAll().stream().filter(item -> item.getId().equals(itemId))
                    .reduce((a, b) -> {
                        throw new IllegalStateException("Multiple elements: " + a + ", " + b);
                    }).get();

            if (filteredItem.getMediaType().equals(MediaType.BOOK) &&
                    !filteredItem.isLoaned()) {

                filteredItem.setLoaned(true);
                LocalDate dueDate = currentDate.plus(4, ChronoUnit.WEEKS);

                Loan newLoan = new Loan(filteredItem, filteredUser, issueDate, dueDate, numRenews, false);

                filteredUser.getLoan().add(newLoan);
                loanRepo.save(newLoan);

            } else if (filteredItem.getMediaType().equals(MediaType.MULTIMEDIA) &&
                    !filteredItem.isLoaned()) {

                filteredItem.setLoaned(true);
                LocalDate dueDate = currentDate.plus(1, ChronoUnit.WEEKS);

                Loan newLoan = new Loan(filteredItem, filteredUser, issueDate, dueDate, numRenews, false);

                filteredUser.getLoan().add(newLoan);
                loanRepo.save(newLoan);
            }
        }

    public void renewLoan(Long loanId) {
        LocalDate currentDate = LocalDate.now();

        Loan filteredLoan = loanRepo.findAll().stream().filter(loan -> loan.getId().equals(loanId))
                .reduce((a, b) -> {
                    throw new IllegalStateException("Multiple elements: " + a + ", " + b);
                }).get();

            if (filteredLoan.getItem().getMediaType().equals(MediaType.BOOK)
                    && filteredLoan.getNumRenews() < 3 && !filteredLoan.isReturned()) {

                    LocalDate dueDate = currentDate.plus(2, ChronoUnit.WEEKS);
                    int numRenews = filteredLoan.getNumRenews() + 1;

                    filteredLoan.setDueDate(dueDate);
                    filteredLoan.setNumRenews(numRenews);

                    loanRepo.save(filteredLoan);

            } else if (filteredLoan.getItem().getMediaType().equals(MediaType.MULTIMEDIA)
                    && filteredLoan.getNumRenews() < 2 && !filteredLoan.isReturned()) {

                    LocalDate dueDate = currentDate.plus(1, ChronoUnit.WEEKS);
                    int numRenews = filteredLoan.getNumRenews() + 1;

                    filteredLoan.setDueDate(dueDate);
                    filteredLoan.setNumRenews(numRenews);

                    loanRepo.save(filteredLoan);
                }
            }

    public void returnLoan(Long loanId) {
        LocalDate currentDate = LocalDate.now();

        Loan filteredLoan = loanRepo.findAll().stream().filter(loan -> loan.getId().equals(loanId))
                .reduce((a, b) -> {
                    throw new IllegalStateException("Multiple elements: " + a + ", " + b);
                }).get();

            if (filteredLoan.getDueDate().isAfter(currentDate)
                    || filteredLoan.getDueDate().equals(currentDate)) {

                filteredLoan.getItem().setLoaned(false);
                filteredLoan.setReturned(true);

                loanRepo.save(filteredLoan);
            }
        }
}
