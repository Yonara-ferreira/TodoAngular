package com.br.todo.Project.Domain.DTO;

import com.br.todo.Project.Domain.Todo;

import java.time.LocalDateTime;

public record TodoListingData(String title, String description, LocalDateTime completionDate, Boolean completed) {

    public TodoListingData(Todo todo){
        this(todo.getTitle(),
                todo.getDescription(),
                todo.getCompletionDate(),
                todo.getCompleted());
    }


}
