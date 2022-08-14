package com.example.demo.DTO;

import com.example.demo.DTO.LoanDto;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class LibraryUserDto implements Serializable {
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Set<LoanDto> loan;
}
