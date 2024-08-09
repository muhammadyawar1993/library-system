package com.assignment.librarysystem.controller;
import com.assignment.librarysystem.model.Book;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.assignment.librarysystem.service.BookService;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Operation(summary = "Register a new book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book registered successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public com.assignment.librarysystem.response.ApiResponse<Book> registerBook(@RequestBody Book book) {
        return bookService.registerBook(book);
    }

    @Operation(summary = "Get all books")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Books retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public com.assignment.librarysystem.response.ApiResponse<List<Book>> getAllBooks() {
        return bookService.getAllBooks();
    }
}
