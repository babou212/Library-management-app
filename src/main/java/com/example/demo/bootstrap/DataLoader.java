package com.example.demo.bootstrap;

import com.example.demo.model.Item;
import com.example.demo.model.Loan;
import com.example.demo.model.MediaType;
import com.example.demo.model.User;
import com.example.demo.repository.ItemRepo;
import com.example.demo.repository.LoanRepo;
import com.example.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {
    private final ItemRepo itemRepo;

    private final LoanRepo loanRepo;

    private final UserRepo userRepo;

    @Override
    public void run(String... args) {
        User user1 = User.builder().userId(1L).firstName("Tim").lastName("Smith").email("tim_smith@yahoo.com").build();
        userRepo.save(user1);

        LocalDate currentDate = LocalDate.now();
        LocalDate dueDate = currentDate.plus(4, ChronoUnit.WEEKS);
        Loan loan1 = Loan.builder().loanId(1L).barcode("345345345345345").issueDate(currentDate)
                .dueDate(dueDate).userId(1L).build();
        loanRepo.save(loan1);

        LocalDate year = LocalDate.of(1872, 7, 16);
        Item item1 = Item.builder().itemId(1L).barcode("34224234234").author("Oscar Wilde").title("something")
                .year(year).mediaType(MediaType.BOOK).ISBN("sdf345345345345345").build();
        itemRepo.save(item1);
    }
}
