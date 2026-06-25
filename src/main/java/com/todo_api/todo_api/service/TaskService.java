package com.todo_api.todo_api.service;

import com.todo_api.todo_api.model.Task;
import com.todo_api.todo_api.exception.TaskNotFoundException;
import com.todo_api.todo_api.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAll() {
        return this.taskRepository.findAll();
    }

    public Task getTask(Long id){
        return this.taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(" task with id " + id + " not found"));
    }

    public Task create(Task task){
        taskRepository.save(task);
        return task;
    }

    public Task update(Long id, Task updatedTask){
        Task existingTask =  this.taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(" task with id " + id + " not found"));
        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDone(updatedTask.isDone());
        return taskRepository.save(existingTask);
    }

    public void delete(Long id){
        if(!this.taskRepository.existsById(id)){
            throw new TaskNotFoundException(" task with id " + id + " not found");
        }
        this.taskRepository.deleteById(id);
    }
}