package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NonNull;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public record LibraryUserDto(@NonNull Long id, String firstName, String lastName, @Email String email,
                             Set<LoanDto> loan) implements Serializable {
}
