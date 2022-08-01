package com.example.demo.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "loans")
@Component
public class Loan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loan_id", nullable = false)
    private Long loanId;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Item itemId;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private User user;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "number_renews")
    private int numRenews;

    public Loan(LocalDate issueDate, LocalDate dueDate, int numRenews) {
    }
}
