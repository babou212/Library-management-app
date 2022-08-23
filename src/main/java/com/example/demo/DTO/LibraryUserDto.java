package com.example.demo.DTO;

import lombok.NonNull;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Set;

public record LibraryUserDto(@NonNull Long id, String firstName, String lastName, @Email String email,
                             Set<LoanDto> loan) implements Serializable {
}
