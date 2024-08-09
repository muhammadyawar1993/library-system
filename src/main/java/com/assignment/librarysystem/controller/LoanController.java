package com.assignment.librarysystem.controller;

import com.assignment.librarysystem.model.Loan;
import com.assignment.librarysystem.service.LoanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @Operation(summary = "Borrow a book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book borrowed successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Borrower or book not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/borrow")
    public com.assignment.librarysystem.response.ApiResponse<Loan> borrowBook(@RequestParam Long borrowerId, @RequestParam Long bookId) {
        return loanService.borrowBook(borrowerId, bookId);
    }

    @Operation(summary = "Return a book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book returned successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Loan not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/return")
    public com.assignment.librarysystem.response.ApiResponse<Loan> returnBook(@RequestParam Long loanId) {
        return loanService.returnBook(loanId);
    }

    @Operation(summary = "Get borrowed books by borrower ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Books retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Borrower not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/borrowed-books/{borrowerId}")
    public com.assignment.librarysystem.response.ApiResponse<List<Loan>> getBorrowedBooks(@PathVariable Long borrowerId) {
        return loanService.getBorrowedBooks(borrowerId);
    }

    @Operation(summary = "Get returned books by borrower ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Books retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Borrower not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/returned-books/{borrowerId}")
    public com.assignment.librarysystem.response.ApiResponse<List<Loan>> getReturnedBooks(@PathVariable Long borrowerId) {
        return loanService.getReturnedBooks(borrowerId);
    }
}