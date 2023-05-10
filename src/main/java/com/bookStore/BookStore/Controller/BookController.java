package com.bookStore.BookStore.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookStore.BookStore.Service.BookService;
import com.bookStore.BookStore.dto.BookDto;
import com.bookStore.BookStore.entities.Book;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id) {
        Book book = bookService.findById(id);

        return ResponseEntity.ok().body(book);

    }

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        List<Book> book = bookService.findAll();

        return ResponseEntity.ok().body(book);
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        book = bookService.create(book);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(book.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BookDto> update(@PathVariable Integer id, @RequestBody BookDto book) {
        Book book2 = bookService.update(id, book);

        return ResponseEntity.ok().body(new BookDto(book2));

    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        bookService.delete(id);
    }

}
