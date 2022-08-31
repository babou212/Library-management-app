package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NonNull;

import java.io.Serializable;
import java.time.LocalDate;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public record LoanDto(@NonNull Long id, ItemDto item, LibraryUserDto libraryUser, LocalDate issueDate,
                      LocalDate dueDate, int numRenews) implements Serializable {
}
