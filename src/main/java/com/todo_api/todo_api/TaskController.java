package com.todo_api.todo_api;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTasks(@RequestBody Task task) {
        task.setId(nextId++);
        tasks.add(task);
        return task;

    }
    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Long id) {
        for (Task task : this.tasks) {
           if(task.getId().equals(id)){
               return task;
           }
        }
        throw new TaskNotFoundException("Task not found");
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask){
        for (Task task : this.tasks) {
            if(task.getId().equals(id)){
            task.setTitle(updatedTask.getTitle());
            task.setDone(updatedTask.isDone());
            return task;
            }
        }
        throw  new TaskNotFoundException("Task not found");
    }

    @DeleteMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long id){
        boolean removed = this.tasks.removeIf(task -> task.getId().equals(id));
        if (!removed){
            throw new TaskNotFoundException("Task to delete doesn't exist");
        }
    }

}
