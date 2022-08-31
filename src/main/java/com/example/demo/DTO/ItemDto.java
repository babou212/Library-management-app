package com.example.demo.DTO;

import com.example.demo.model.MediaType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NonNull;
import org.hibernate.validator.constraints.ISBN;

import java.io.Serializable;
import java.time.LocalDate;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public record ItemDto(@NonNull Long id, String author, String title, LocalDate year, MediaType mediaType,
                      @ISBN String ISBN) implements Serializable {
}
