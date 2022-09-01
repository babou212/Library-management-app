package com.example.demo.service;

import com.example.demo.model.Item;
import com.example.demo.model.Loan;
import com.example.demo.model.MediaType;
import com.example.demo.model.LibraryUser;
import com.example.demo.repository.ItemRepo;
import com.example.demo.repository.LoanRepo;
import com.example.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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

            if (itemRepo.findById(itemId).get().getMediaType().equals(MediaType.BOOK) &&
                    !itemRepo.findById(itemId).get().isLoaned()) {

                LibraryUser user = userRepo.findById(userId).get();
                Item item = itemRepo.findById(itemId).get();
                item.setLoaned(true);
                LocalDate dueDate = currentDate.plus(4, ChronoUnit.WEEKS);

                Loan newLoan = new Loan(item, user, issueDate, dueDate, numRenews, false);

                user.getLoan().add(newLoan);

                userRepo.flush();
                userRepo.save(user);
                loanRepo.save(newLoan);

            } else if (itemRepo.findById(itemId).get().getMediaType().equals(MediaType.MULTIMEDIA) &&
                    !itemRepo.findById(itemId).get().isLoaned()) {

                LibraryUser user = userRepo.findById(userId).get();
                Item item = itemRepo.findById(itemId).get();
                item.setLoaned(true);
                LocalDate dueDate = currentDate.plus(1, ChronoUnit.WEEKS);

                Loan newLoan = new Loan(item, user, issueDate, dueDate, numRenews, false);

                user.getLoan().add(newLoan);
                loanRepo.save(newLoan);
            }
        }

    public void renewLoan(Long loanId) {
        LocalDate currentDate = LocalDate.now();

                if (loanRepo.findById(loanId).get().getItem().getMediaType().equals(MediaType.BOOK)
                        && loanRepo.findById(loanId).get().getNumRenews() < 3) {

                    if (!loanRepo.findById(loanId).get().isReturned()) {
                        LocalDate dueDate = currentDate.plus(2, ChronoUnit.WEEKS);
                        int numRenews = loanRepo.findById(loanId).get().getNumRenews() + 1;
                        Loan loanFromDb = loanRepo.findById(loanId).get();

                        loanFromDb.setDueDate(dueDate);
                        loanFromDb.setNumRenews(numRenews);

                        loanRepo.save(loanFromDb);
                    }

                } else if (loanRepo.findById(loanId).get().getItem().getMediaType().equals(MediaType.MULTIMEDIA)
                        && loanRepo.findById(loanId).get().getNumRenews() < 2) {

                    if (!loanRepo.findById(loanId).get().isReturned()) {
                        LocalDate dueDate = currentDate.plus(1, ChronoUnit.WEEKS);
                        int numRenews = loanRepo.findById(loanId).get().getNumRenews() + 1;
                        Loan loanFromDb = loanRepo.findById(loanId).get();

                        loanFromDb.setDueDate(dueDate);
                        loanFromDb.setNumRenews(numRenews);

                        loanRepo.save(loanFromDb);
                    }
                }
    }

    public void returnLoan(Long loanId) {
        LocalDate currentDate = LocalDate.now();

              if (loanRepo.findById(loanId).get().getDueDate().isAfter(currentDate)
                      || loanRepo.findById(loanId).get().getDueDate().equals(currentDate)) {

                  Loan receivedLoan = loanRepo.findById(loanId).get();
                  receivedLoan.getItem().setLoaned(false);
                receivedLoan.setReturned(true);

                LibraryUser user = receivedLoan.getLibraryUser();
                user.setLoan(null);

                loanRepo.save(receivedLoan);

                userRepo.flush();
                userRepo.save(user);
            }
    }
}
