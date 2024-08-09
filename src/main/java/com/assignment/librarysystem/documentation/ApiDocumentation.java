package com.assignment.librarysystem.documentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Library System API", description = "Operations related to Library System")
public class ApiDocumentation {

    @Operation(summary = "Register a new book")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully registered the book"),
            @ApiResponse(responseCode = "400", description = "Invalid request data")
    })
    public @interface RegisterBook {
    }

    @Operation(summary = "Get all books")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully fetched the books"),
            @ApiResponse(responseCode = "404", description = "Books not found")
    })
    public @interface GetAllBooks {
    }

    @Operation(summary = "Register a new borrower")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully registered the borrower"),
            @ApiResponse(responseCode = "400", description = "Invalid request data")
    })
    public @interface RegisterBorrower {
    }

    @Operation(summary = "Get all borrowers")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully fetched the borrowers"),
            @ApiResponse(responseCode = "404", description = "Borrowers not found")
    })
    public @interface GetAllBorrowers {
    }

    @Operation(summary = "Borrow a book")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully borrowed the book"),
            @ApiResponse(responseCode = "404", description = "Borrower or Book not found"),
            @ApiResponse(responseCode = "400", description = "Book is already borrowed")
    })
    public @interface BorrowBook {
    }

    @Operation(summary = "Return a book")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully returned the book"),
            @ApiResponse(responseCode = "404", description = "Loan not found")
    })
    public @interface ReturnBook {
    }

    @Operation(summary = "Get borrowed books by borrower")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully fetched the borrowed books"),
            @ApiResponse(responseCode = "404", description = "Borrower not found")
    })
    public @interface GetBorrowedBooks {
    }

    @Operation(summary = "Get returned books by borrower")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully fetched the returned books"),
            @ApiResponse(responseCode = "404", description = "Borrower not found")
    })
    public @interface GetReturnedBooks {
    }
}
