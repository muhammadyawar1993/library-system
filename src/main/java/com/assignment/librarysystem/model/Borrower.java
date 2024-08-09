package com.assignment.librarysystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "borrower")
@AllArgsConstructor
@NoArgsConstructor
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "borrower_id_gen")
    @SequenceGenerator(name = "borrower_id_gen", sequenceName = "borrower_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    public Borrower(Long borrowerId) {
        this.id = borrowerId;
    }
}

