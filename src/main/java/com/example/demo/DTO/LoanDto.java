package com.example.demo.DTO;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.time.LocalDate;

public record LoanDto(@NonNull Long id, ItemDto item, LibraryUserDto libraryUser, LocalDate issueDate,
                      LocalDate dueDate, int numRenews) implements Serializable {
}
