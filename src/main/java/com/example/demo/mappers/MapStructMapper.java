package com.example.demo.mappers;

import com.example.demo.DTO.ItemDto;
import com.example.demo.DTO.LibraryUserDto;
import com.example.demo.DTO.LoanDto;
import com.example.demo.model.Item;
import com.example.demo.model.LibraryUser;
import com.example.demo.model.Loan;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    ItemDto convertItemToDto(Item item);
    LibraryUserDto convertUserToDto(LibraryUser libraryUser);
    LoanDto convertLoanToDto(Loan loan);
}
