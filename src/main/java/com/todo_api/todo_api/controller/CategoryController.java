package com.todo_api.todo_api.controller;


import com.todo_api.todo_api.model.Category;
import com.todo_api.todo_api.model.Task;
import com.todo_api.todo_api.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories(){ return this.categoryService.getAll();}

    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable Long id){
        return this.categoryService.getCategory(id);
    }

    @PostMapping("/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public Category createCategory( @RequestBody @Valid Category category){
        return this.categoryService.create(category);
    }

    @PutMapping("/categories/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody @Valid Category category){
        return this.categoryService.update(id, category);
    }

    @DeleteMapping("/categories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable Long id){
         this.categoryService.delete(id);
    }

    @GetMapping("/categories/{id}/tasks")
    public List<Task> getTaskCategory(@PathVariable Long id){
        return this.categoryService.getTasksByCategoryId(id);
    }
}
