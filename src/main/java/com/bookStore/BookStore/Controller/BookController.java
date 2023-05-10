package com.bookStore.BookStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookStore.BookStore.Service.BookService;
import com.bookStore.BookStore.entities.Book;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    public ResponseEntity<Book> findById(Integer id) {
        Book book = bookService.findById(id);

        return ResponseEntity.ok().body(book);

    }
}
