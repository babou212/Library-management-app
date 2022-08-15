package com.example.demo.bootstrap;

import com.example.demo.model.Item;
import com.example.demo.model.LibraryUser;
import com.example.demo.model.Loan;
import com.example.demo.model.MediaType;
import com.example.demo.repository.ItemRepo;
import com.example.demo.repository.LoanRepo;
import com.example.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RequiredArgsConstructor
@Configuration
public class DataLoader implements CommandLineRunner {
    private final ItemRepo itemRepo;

    private final LoanRepo loanRepo;

    private final UserRepo userRepo;

    @Override
    public void run(String... args) {
        LibraryUser libraryUser1 = LibraryUser.builder().firstName("Tim").lastName("Smith")
                .email("tim_smith123@yahoo.com").build();
        userRepo.save(libraryUser1);

        LocalDate currentDate = LocalDate.now();
        LocalDate dueDate = currentDate.plus(4, ChronoUnit.WEEKS);
        Loan loan1 = Loan.builder().issueDate(currentDate)
                .dueDate(dueDate).libraryUser(libraryUser1).build();

        LocalDate year = LocalDate.of(1887, 3, 23);
        Item item1 = Item.builder().author("Oscar Wilde").title("The Canterville Ghost")
                .year(year).mediaType(MediaType.BOOK).ISBN("9780003700947").build();
        itemRepo.save(item1);

        loan1.setItem(item1);
        loanRepo.save(loan1);
    }
}
