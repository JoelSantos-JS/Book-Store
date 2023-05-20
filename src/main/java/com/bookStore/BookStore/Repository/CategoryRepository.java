package com.bookStore.BookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookStore.BookStore.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
