package com.example.demo.DTO;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class LoanDto implements Serializable {
    @NonNull
    private final Long id;

    private final ItemDto item;

    private final LibraryUserDto libraryUser;

    private final LocalDate issueDate;

    private final LocalDate dueDate;

    private final int numRenews;
}
