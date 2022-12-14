package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LOANS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Loan extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    private Item item;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "library_user")
    private LibraryUser libraryUser;

    @Column(name = "issue_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate issueDate;

    @Column(name = "due_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dueDate;

    @Column(name = "number_renews")
    private int numRenews;

    @Column(name = "returned")
    private boolean isReturned;
}
