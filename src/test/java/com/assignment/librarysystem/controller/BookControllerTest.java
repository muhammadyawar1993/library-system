package com.assignment.librarysystem.controller;

import com.assignment.librarysystem.model.Book;
import com.assignment.librarysystem.response.ApiResponse;
import com.assignment.librarysystem.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    public BookControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterBook() {
        Book book = new Book();
        ApiResponse<Book> response = new ApiResponse<>(true, "Book registered successfully", book);
        when(bookService.registerBook(book)).thenReturn(response);

        ApiResponse<Book> result = bookController.registerBook(book);

        assertEquals(response, result);
    }

    @Test
    public void testGetAllBooks() {
        Book book = new Book();
        List<Book> books = Collections.singletonList(book);
        ApiResponse<List<Book>> response = new ApiResponse<>(true, "Books fetched successfully", books);
        when(bookService.getAllBooks()).thenReturn(response);

        ApiResponse<List<Book>> result = bookController.getAllBooks();

        assertEquals(response, result);
    }
}
