package com.assignment.librarysystem.service;

import com.assignment.librarysystem.model.Loan;
import com.assignment.librarysystem.response.ApiResponse;

import java.util.List;

public interface LoanService {
    ApiResponse<Loan> borrowBook(Long borrowerId, Long bookId);
    ApiResponse<Loan> returnBook(Long loanId);
    ApiResponse<List<Loan>> getBorrowedBooks(Long borrowerId);
    ApiResponse<List<Loan>> getReturnedBooks(Long borrowerId);

}
