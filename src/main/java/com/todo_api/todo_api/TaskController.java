package com.todo_api.todo_api;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController (TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks(){
        return this.taskRepository.findAll();
    }
    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTasks(@RequestBody Task task) {
        taskRepository.save(task);
        return task;

    }
    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return this.taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(" task with id " + id + " not found"));
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask){
      Task existingTask =  this.taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(" task with id " + id + " not found"));
     existingTask.setTitle(updatedTask.getTitle());
     existingTask.setDone(updatedTask.isDone());
     return taskRepository.save(existingTask);

    }

    @DeleteMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long id){
        if(!this.taskRepository.existsById(id)){
            throw new TaskNotFoundException(" task with id " + id + " not found");
        }
        this.taskRepository.deleteById(id);
    }

}
