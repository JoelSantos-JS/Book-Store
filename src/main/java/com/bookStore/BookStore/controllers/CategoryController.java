package com.bookStore.BookStore.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookStore.BookStore.dto.CategoryDto;
import com.bookStore.BookStore.entities.Category;
import com.bookStore.BookStore.services.CategoryService;

import jakarta.validation.Valid;

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

    @PostMapping
    public ResponseEntity<Category> save(@Valid @RequestBody Category category) {
        category = categoryService.create(category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoryDto> update(@Valid @PathVariable Integer id, @RequestBody CategoryDto category) {
        Category category2 = categoryService.update(id, category);

        return ResponseEntity.ok().body(new CategoryDto(category2));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        categoryService.delete(id);

    }

}
