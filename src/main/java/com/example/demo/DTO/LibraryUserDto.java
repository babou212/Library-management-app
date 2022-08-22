package com.example.demo.DTO;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Set;

@Data
public class LibraryUserDto implements Serializable {
    @NonNull
    private final Long id;

    private final String firstName;

    private final String lastName;

    @Email
    private final String email;

    private final Set<LoanDto> loan;
}
