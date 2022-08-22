package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Set;

@Data
public class LibraryUserDto implements Serializable {
    @NonNull
    //@JsonProperty("id")
    private final Long id;

    //@JsonProperty("firstName")
    private final String firstName;

    //@JsonProperty("lastName")
    private final String lastName;

    @Email
    //@JsonProperty("email")
    private final String email;

    //@JsonProperty("loans")
    private final Set<LoanDto> loan;
}
