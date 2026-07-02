package com.todo_api.todo_api.repository;

import com.todo_api.todo_api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByCategoryId (Long categoryId);
}
