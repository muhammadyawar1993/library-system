package com.assignment.librarysystem.service.impl;

import com.assignment.librarysystem.model.Book;
import com.assignment.librarysystem.repository.BookRepository;
import com.assignment.librarysystem.response.ApiResponse;
import com.assignment.librarysystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public ApiResponse<Book> registerBook(Book book) {
        List<Book> existingBooks = bookRepository.findByIsbn(book.getIsbn());

        // Check if the list is not empty
        if (!existingBooks.isEmpty()) {
            // Iterate through existing books to check if any match the title and author
            for (Book existing : existingBooks) {
                if (existing.getTitle().equals(book.getTitle()) && existing.getAuthor().equals(book.getAuthor())) {
                    // If all fields are the same, allow saving the book
                    Book savedBook = bookRepository.save(book);
                    return new ApiResponse<>(true, "Book registered successfully", savedBook);
                }
            }
            // If no matching book with the same title and author is found, return an error
            return new ApiResponse<>(false, "Book with the same ISBN must have the same title and author", null);
        }

        // If no book with the same ISBN exists, save the new book
        Book savedBook = bookRepository.save(book);
        return new ApiResponse<>(true, "Book registered successfully", savedBook);
    }

    public ApiResponse<List<Book>> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return new ApiResponse<>(true, "Books retrieved successfully", books);
    }
}
