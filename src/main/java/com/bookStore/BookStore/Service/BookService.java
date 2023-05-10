package com.bookStore.BookStore.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.BookStore.Repository.BookRepository;
import com.bookStore.BookStore.Service.exceptions.ObjectNotFound;
import com.bookStore.BookStore.entities.Book;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Method find a book by id
    public Book findById(Integer id) {
        Optional<Book> book = bookRepository.findById(id);

        return book.orElseThrow(() -> new ObjectNotFound("Book not found!"));
    }

}
