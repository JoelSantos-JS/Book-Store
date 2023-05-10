package com.bookStore.BookStore.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookStore.BookStore.Service.CategoryService;
import com.bookStore.BookStore.dto.CategoryDto;
import com.bookStore.BookStore.entities.Category;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id) {
        Category category = categoryService.findById(id);

        return ResponseEntity.ok().body(category);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll() {
        List<Category> list = categoryService.findAll();

        List<CategoryDto> listDto = list.stream().map(e -> new CategoryDto(e)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);

    }

}
