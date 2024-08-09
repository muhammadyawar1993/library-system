package com.assignment.librarysystem.controller;

import com.assignment.librarysystem.model.Loan;
import com.assignment.librarysystem.response.ApiResponse;
import com.assignment.librarysystem.service.LoanService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class LoanControllerTest {

    @Mock
    private LoanService loanService;

    @InjectMocks
    private LoanController loanController;

    public LoanControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBorrowBook() {
        Long borrowerId = 1L;
        Long bookId = 1L;
        Loan loan = new Loan();
        ApiResponse<Loan> response = new ApiResponse<>(true, "Book successfully borrowed", loan);
        when(loanService.borrowBook(borrowerId, bookId)).thenReturn(response);

        ApiResponse<Loan> result = loanController.borrowBook(borrowerId, bookId);

        assertEquals(response, result);
    }

    @Test
    public void testReturnBook() {
        Long loanId = 1L;
        Loan loan = new Loan();
        ApiResponse<Loan> response = new ApiResponse<>(true, "Book successfully returned", loan);
        when(loanService.returnBook(loanId)).thenReturn(response);

        ApiResponse<Loan> result = loanController.returnBook(loanId);

        assertEquals(response, result);
    }

    @Test
    public void testGetBorrowedBooks() {
        Long borrowerId = 1L;
        Loan loan = new Loan();
        List<Loan> loans = Collections.singletonList(loan);
        ApiResponse<List<Loan>> response = new ApiResponse<>(true, "Borrowed books fetched successfully", loans);
        when(loanService.getBorrowedBooks(borrowerId)).thenReturn(response);

        ApiResponse<List<Loan>> result = loanController.getBorrowedBooks(borrowerId);

        assertEquals(response, result);
    }

    @Test
    public void testGetReturnedBooks() {
        Long borrowerId = 1L;
        Loan loan = new Loan();
        List<Loan> loans = Collections.singletonList(loan);
        ApiResponse<List<Loan>> response = new ApiResponse<>(true, "Returned books fetched successfully", loans);
        when(loanService.getReturnedBooks(borrowerId)).thenReturn(response);

        ApiResponse<List<Loan>> result = loanController.getReturnedBooks(borrowerId);

        assertEquals(response, result);
    }
}