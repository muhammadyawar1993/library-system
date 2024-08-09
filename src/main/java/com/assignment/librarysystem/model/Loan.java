package com.assignment.librarysystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_id_gen")
    @SequenceGenerator(name = "loan_id_gen", sequenceName = "loan_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "borrower_id", nullable = false)
    private Borrower borrower;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    private boolean returned;
}
