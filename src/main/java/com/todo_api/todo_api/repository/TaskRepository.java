package com.todo_api.todo_api.repository;

import com.todo_api.todo_api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long> {
}
