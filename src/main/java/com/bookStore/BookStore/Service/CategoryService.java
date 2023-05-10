package com.bookStore.BookStore.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.BookStore.Repository.CategoryRepository;
import com.bookStore.BookStore.Service.exceptions.DateIntegrityViolention;
import com.bookStore.BookStore.Service.exceptions.ObjectNotFound;
import com.bookStore.BookStore.dto.CategoryDto;
import com.bookStore.BookStore.entities.Category;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Method find a category by id
    public Category findById(Integer id) {
        Optional<Category> category = categoryRepository.findById(id);

        return category.orElseThrow(() -> new ObjectNotFound("Object not found"));

    }

    public List<Category> findAll() {
        return categoryRepository.findAll();

    }

    public Category create(Category category) {
        category.setId(null);

        return categoryRepository.save(category);
    }

    public Category update(Integer id, CategoryDto category) {
        Category entity = findById(id);

        entity.setName(category.getName());
        entity.setDescription(category.getDescription());

        return categoryRepository.save(entity);

    }

    public Category delete(Integer id) {
        Category entity = findById(id);

        try {
            categoryRepository.delete(entity);
        } catch (DateIntegrityViolention e) {
            // TODO: handle exception
            throw new DateIntegrityViolention("Can't delete a category with books");
        }

        return entity;
    }

}
