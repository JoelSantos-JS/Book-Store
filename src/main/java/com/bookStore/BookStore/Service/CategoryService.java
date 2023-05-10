package com.bookStore.BookStore.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.BookStore.Repository.CategoryRepository;
import com.bookStore.BookStore.Service.exceptions.ObjectNotFound;
import com.bookStore.BookStore.entities.Category;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Method find a category by id
    public Category findById(Integer id) {
        Optional<Category> category = categoryRepository.findById(id);

        return category.orElseThrow(() -> new ObjectNotFound("Object not found"));

    }
}
