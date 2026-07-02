package com.todo_api.todo_api.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reminders")
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Message cannot be empty")
    @Size(max = 100, message = "Message have 100 characters maximum")
    private String message;
    @NotNull(message = "Please choice a due date")
    @Future(message = "Due date have to be choice for future")
    private LocalDateTime dueDate;


    public Reminder(){}

    public Reminder(Long id, String message, LocalDateTime dueDate){
        this.id = id;
        this.message = message;
        this.dueDate = dueDate;
    }

    public Long getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    public LocalDateTime getDueDate() {
        return this.dueDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
