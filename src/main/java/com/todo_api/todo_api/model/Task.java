package com.todo_api.todo_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tasks")


public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title can't be empty")
    private String title;
    private boolean done;

    public Task() {

    }

    public Task(String title) {
        this.title = title;
        this.done = false;
    }

    public boolean isDone() {
        return this.done;
    }

    public String getTitle() {
        return this.title;
    }

    public Long getId() {
        return this.id;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
