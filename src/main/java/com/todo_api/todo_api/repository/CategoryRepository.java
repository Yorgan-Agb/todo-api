package com.todo_api.todo_api.repository;

import com.todo_api.todo_api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
