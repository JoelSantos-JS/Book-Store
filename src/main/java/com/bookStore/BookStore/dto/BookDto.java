package com.bookStore.BookStore.dto;

import java.io.Serializable;

import com.bookStore.BookStore.entities.Book;

public class BookDto implements Serializable {
    private Integer id;
    private String title;
    private String author;
    private String text;

    public BookDto() {

    }

    public BookDto(Book book) {

        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.text = book.getText();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
