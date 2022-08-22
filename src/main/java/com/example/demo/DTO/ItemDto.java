package com.example.demo.DTO;

import com.example.demo.model.MediaType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.ISBN;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ItemDto implements Serializable {
    @NonNull
    //@JsonProperty("id")
    private final Long id;

    //@JsonProperty("author")
    private final String author;

    //@JsonProperty("title")
    private final String title;

    //@JsonProperty("year")
    private final LocalDate year;

    //@JsonProperty("mediaType")
    private final MediaType mediaType;

    @ISBN
    //@JsonProperty("ISBN")
    private final String ISBN;
}
