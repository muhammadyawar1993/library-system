package com.assignment.librarysystem.service;

import com.assignment.librarysystem.model.Book;
import com.assignment.librarysystem.response.ApiResponse;

import java.util.List;

public interface BookService {
    ApiResponse<Book> registerBook(Book book);

    ApiResponse<List<Book>> getAllBooks();
}
