package com.bookStore.BookStore.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookStore.BookStore.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
