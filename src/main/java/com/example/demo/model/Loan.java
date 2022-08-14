package com.example.demo.model;

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
@Table(name = "loans")
@Component
public class Loan extends BaseEntity {
    @OneToOne
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    private LibraryUser libraryUser;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "number_renews")
    private int numRenews;
}
