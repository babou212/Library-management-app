package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "items")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
@Component
public class Item extends BaseEntity  {

    @Column(name = "author")
    private String author;

    @Column(name = "title")
    private String title;

    @Column(name = "release_year")
    private LocalDate year;

    @Column(name = "media_type")
    @Enumerated(EnumType.STRING)
    private MediaType mediaType;

    @Column(name = "ISBN")
    private String ISBN;
}
