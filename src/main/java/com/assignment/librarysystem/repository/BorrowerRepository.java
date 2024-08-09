package com.assignment.librarysystem.repository;

import com.assignment.librarysystem.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
    Borrower findByEmail(String email);
}
