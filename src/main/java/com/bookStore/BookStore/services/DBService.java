package com.bookStore.BookStore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.BookStore.entities.Book;
import com.bookStore.BookStore.entities.Category;
import com.bookStore.BookStore.repositories.BookRepository;
import com.bookStore.BookStore.repositories.CategoryRepository;

@Service
public class DBService {

    @Autowired
    private CategoryRepository cr;

    @Autowired
    private BookRepository bs;

    public void instanciaDados() {

        Category cat1 = new Category(null, "Informática", "Livros de TI");
        Category cat2 = new Category(null, "Ficcção Científica", "Ficcção científica");
        Category cat3 = new Category(null, "Biografias", "Livros de Biografias");

        Book l1 = new Book(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
        Book l2 = new Book(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem ipsum", cat1);
        Book l3 = new Book(null, "The Time Machine", "H.G. Wells", "Lorem ipsum", cat2);
        Book l4 = new Book(null, "The War of the Worlds", "H.G. Wells", "Lorem ipsum", cat2);
        Book l5 = new Book(null, "I, Robot", "Isaac Asimov", "Lorem ipsum", cat2);

        cat1.getBooks().addAll(Arrays.asList(l1, l2));
        cat2.getBooks().addAll(Arrays.asList(l3, l4, l5));

        this.cr.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.bs.saveAll(Arrays.asList(l1, l2, l3, l4, l5));

    }
}
