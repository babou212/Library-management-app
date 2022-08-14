package com.example.demo.DTO;

import com.example.demo.model.MediaType;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ItemDto implements Serializable {
    private final Long id;
    private final String author;
    private final String title;
    private final LocalDate year;
    private final MediaType mediaType;
    private final String ISBN;
}
