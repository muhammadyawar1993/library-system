package com.assignment.librarysystem.repository;

import com.assignment.librarysystem.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    Optional<Loan> findByBookIdAndReturnedFalse(Long bookId);
    List<Loan> findByBorrowerIdAndReturnedFalse(Long borrowerId);
    List<Loan> findByBorrowerIdAndReturnedTrue(Long borrowerId);

}
