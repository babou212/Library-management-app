package com.example.demo.DTO;

import com.example.demo.model.MediaType;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.ISBN;

import java.io.Serializable;
import java.time.LocalDate;

public record ItemDto(@NonNull Long id, String author, String title, LocalDate year, MediaType mediaType,
                      @ISBN String ISBN) implements Serializable {
}
