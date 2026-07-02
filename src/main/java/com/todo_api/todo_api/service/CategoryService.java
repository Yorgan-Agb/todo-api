package com.todo_api.todo_api.service;

import com.todo_api.todo_api.exception.CategoryNotFoundException;
import com.todo_api.todo_api.model.Category;
import com.todo_api.todo_api.model.Task;
import com.todo_api.todo_api.repository.CategoryRepository;
import com.todo_api.todo_api.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final TaskRepository taskRepository;

    public CategoryService(CategoryRepository categoryRepository, TaskRepository taskRepository){
        this.categoryRepository = categoryRepository;
        this.taskRepository = taskRepository;
    }

    public List<Category> getAll(){
        return this.categoryRepository.findAll();
    }

    public Category getCategory(Long id){
        return this.categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category doesn't exist"));
    }

    public Category create(Category category){
        return this.categoryRepository.save(category);
    }

    public Category update(Long id, Category updatedCategory){
        Category toUpdate = this.categoryRepository.findById(id).orElseThrow(() ->  new CategoryNotFoundException("Category doesn't exist"));
        toUpdate.setName(updatedCategory.getName());
        toUpdate.setColor(updatedCategory.getColor());
        return categoryRepository.save(toUpdate);
    }

    public void delete(Long id){
    if (!this.categoryRepository.existsById(id)){
      throw new CategoryNotFoundException("Category doesn't exist");
    }
    this.categoryRepository.deleteById(id);
    }

    public List<Task> getTasksByCategoryId(Long id){
        if (!this.categoryRepository.existsById(id)) {
            throw new CategoryNotFoundException("Category doesn't exist");
        }
        return this.taskRepository.findByCategoryId(id);
    }
}
