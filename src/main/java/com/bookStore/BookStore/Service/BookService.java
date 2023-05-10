package com.bookStore.BookStore.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.BookStore.Repository.BookRepository;
import com.bookStore.BookStore.Service.exceptions.DateIntegrityViolention;
import com.bookStore.BookStore.Service.exceptions.ObjectNotFound;
import com.bookStore.BookStore.dto.BookDto;
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

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book create(Book bookDto) {
        bookDto.setId(null);

        return bookRepository.save(bookDto);
    }

    public Book update(Integer id, BookDto bookDto) {
        Book book = findById(id);

        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setText(book.getText());

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
