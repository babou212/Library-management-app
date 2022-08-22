package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class LoanDto implements Serializable {
    @NonNull
    @JsonProperty("id")
    private final Long id;

    @JsonProperty("item")
    private final ItemDto item;

    @JsonProperty("user")
    private final LibraryUserDto libraryUser;

    @JsonProperty("issueDate")
    private final LocalDate issueDate;

    @JsonProperty("dueDate")
    private final LocalDate dueDate;

    @JsonProperty("numRenews")
    private final int numRenews;
}
