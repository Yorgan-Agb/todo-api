package com.todo_api.todo_api;

public class Task {
    private Long id;
    private String title;
    private boolean done;

    public Task() {

    }

    public Task(Long id, String title) {
        this.id = id;
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
