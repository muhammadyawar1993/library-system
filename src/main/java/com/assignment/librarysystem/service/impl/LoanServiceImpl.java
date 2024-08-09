package com.assignment.librarysystem.service.impl;

import com.assignment.librarysystem.model.Book;
import com.assignment.librarysystem.model.Borrower;
import com.assignment.librarysystem.model.Loan;
import com.assignment.librarysystem.repository.BookRepository;
import com.assignment.librarysystem.repository.BorrowerRepository;
import com.assignment.librarysystem.repository.LoanRepository;
import com.assignment.librarysystem.response.ApiResponse;
import com.assignment.librarysystem.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private BorrowerRepository borrowerRepository;
    @Autowired
    private BookRepository bookRepository;

    @Transactional
    @Override
    public ApiResponse<Loan> borrowBook(Long borrowerId, Long bookId) {
        //Ensure borrower is exist in our system
        Optional<Borrower> borrowerOpt = borrowerRepository.findById(borrowerId);

        if (borrowerOpt.isEmpty()) {
            return new ApiResponse<>(true, "Borrower does not exist in our system", null);
        }

        //Ensure borrower is exist in our system
        Optional<Book> bookOpt = bookRepository.findById(bookId);
        if (bookOpt.isEmpty()) {
            return new ApiResponse<>(true, "Book does not exist in our system", null);
        }

        // Ensure the book is not already borrowed
        Optional<Loan> loanOpt = loanRepository.findByBookIdAndReturnedFalse(bookId);

        if (loanOpt.isPresent()) {
            return new ApiResponse<>(true, "Book is already borrowed", loanOpt.get());
        }

        // Create a new Loan
        Loan loan = new Loan();
        loan.setBorrower(borrowerOpt.get());
        loan.setBook(bookOpt.get());
        loan.setReturned(false);

        loan = loanRepository.save(loan);
        return new ApiResponse<>(true, "Book successfully borrowed", loan);
    }

    @Transactional
    public ApiResponse<Loan> returnBook(Long loanId) {
        // Fetch the loan by its ID
        Optional<Loan> loanOpt = loanRepository.findById(loanId);

        // Check if the loan exists
        if (loanOpt.isEmpty()) {
            return new ApiResponse<>(false, "Loan does not exist", null);
        }

        Loan loan = loanOpt.get();

        // Check if the book has already been returned
        if (loan.isReturned()) {
            return new ApiResponse<>(false, "Book already returned", loan);
        }

        // Mark the book as returned
        loan.setReturned(true);
        Loan savedLoan = loanRepository.save(loan);

        return new ApiResponse<>(true, "Book successfully returned", savedLoan);
    }

    @Override
    @Transactional
    public ApiResponse<List<Loan>> getBorrowedBooks(Long borrowerId) {
        // Fetch loans for the borrower where the book has not been returned
        List<Loan> loans = loanRepository.findByBorrowerIdAndReturnedFalse(borrowerId);

        if (loans.isEmpty()) {
            return new ApiResponse<>(true, "No borrowed books found for this borrower", Collections.emptyList());
        }

        return new ApiResponse<>(true, "Borrowed books fetched successfully", loans);
    }

    @Override
    @Transactional
    public ApiResponse<List<Loan>> getReturnedBooks(Long borrowerId) {
        // Fetch loans for the borrower where the book has not been returned
        List<Loan> loans = loanRepository.findByBorrowerIdAndReturnedTrue(borrowerId);

        if (loans.isEmpty()) {
            return new ApiResponse<>(true, "No Returned books found for this borrower", Collections.emptyList());
        }

        return new ApiResponse<>(true, "Returned books fetched successfully", loans);
    }
}
