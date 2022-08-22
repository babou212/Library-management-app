package com.example.demo.DTO;

import com.example.demo.model.MediaType;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.ISBN;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ItemDto implements Serializable {
    @NonNull
    private final Long id;

    private final String author;

    private final String title;

    private final LocalDate year;

    private final MediaType mediaType;

    @ISBN
    private final String ISBN;
}
