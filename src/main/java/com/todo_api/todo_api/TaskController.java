package com.todo_api.todo_api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {
   private List<Task> tasks = new ArrayList<>();
    long nextId = 1;

    @GetMapping("/tasks")
    public List<Task> getAllTasks(){
        return this.tasks;
    }
    @PostMapping("/tasks")
    public Task createTasks(@RequestBody Task task) {
        task.setId(nextId++);
        tasks.add(task);
        return task;

    }
}
