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
@Entity
@Table(name = "loans")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="libraryUser")
@Component
public class Loan extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private LibraryUser libraryUser;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "number_renews")
    private int numRenews;

    @Column(name = "returned")
    private boolean isReturned;
}
