package com.bookStore.BookStore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.BookStore.dto.BookDto;
import com.bookStore.BookStore.entities.Book;
import com.bookStore.BookStore.entities.Category;
import com.bookStore.BookStore.repositories.BookRepository;
import com.bookStore.BookStore.services.exceptions.DateIntegrityViolention;
import com.bookStore.BookStore.services.exceptions.ObjectNotFound;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryService CategoryService; // injetar o service

    // Method find a book by id
    public Book findById(Integer id) {
        Optional<Book> book = bookRepository.findById(id);

        return book.orElseThrow(() -> new ObjectNotFound("Book not found!"));
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book create(Integer id_cat, Book bookDto) {
        bookDto.setId(null);
        Category category = CategoryService.findById(id_cat); // inje
        bookDto.setCategory(category);

        return bookRepository.save(bookDto);
    }

    public List<Book> findAllByCategory(Integer id) {
        Category obj = CategoryService.findById(id); // injet
        return obj.getBooks();
    }

    public Book update(Integer id, BookDto bookDto) {
        Book book = findById(id);

        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setText(bookDto.getText());

        return bookRepository.save(book);
    }

    public Book delete(Integer id) {
        Book book = findById(id);

        try {
            bookRepository.delete(book);
        } catch (DateIntegrityViolention e) {
            throw new DateIntegrityViolention("Can't delete a book with orders!");
        }

        return book;
    }

}
