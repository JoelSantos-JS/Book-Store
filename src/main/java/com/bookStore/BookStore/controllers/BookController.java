package com.bookStore.BookStore.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookStore.BookStore.dto.BookDto;
import com.bookStore.BookStore.entities.Book;
import com.bookStore.BookStore.services.BookService;

import jakarta.validation.Valid;

@CrossOrigin("*")
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

    @GetMapping(value = "/category/{id}")
    public ResponseEntity<List<BookDto>> findAllByCategory(@PathVariable Integer id) {
        List<Book> list = bookService.findAllByCategory(id);
        List<BookDto> listDTO = list.stream().map(obj -> new BookDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Book> create(@Valid @RequestParam(value = "category", defaultValue = "0") Integer id_cat,
            @RequestBody Book book) {
        book = bookService.create(id_cat, book);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/book/{id}").buildAndExpand(book.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<BookDto> update(@Valid @PathVariable Integer id, @RequestBody BookDto book) {
        Book book2 = bookService.update(id, book);

        return ResponseEntity.ok().body(new BookDto(book2));

    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        bookService.delete(id);
    }

}
