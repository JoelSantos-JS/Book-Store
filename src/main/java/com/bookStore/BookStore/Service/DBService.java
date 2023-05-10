package com.bookStore.BookStore.Service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.BookStore.Repository.BookRepository;
import com.bookStore.BookStore.Repository.CategoryRepository;
import com.bookStore.BookStore.entities.Book;
import com.bookStore.BookStore.entities.Category;

@Service
public class DBService {

    @Autowired
    private CategoryRepository cr;

    @Autowired
    private BookRepository bs;

    public void instanciaDados() {

        Category category = new Category(null, "Ficção Científica", "Tudo sobre ciencia");
        Category category2 = new Category(null, "Arte Científica", "Tudo sobre Arte");

        cr.saveAll(Arrays.asList(category, category2));

        Book book = new Book(null, "Arte da guerra", "JKJ", "Aprendo tudo sobre a arte da guerra", category2);
        Book book2 = new Book(null, "Arte da guerra 2", "JKJ", "Aprendo tudo sobre a arte da guerra", category);

        bs.saveAll(Arrays.asList(book, book2));

    }
}
