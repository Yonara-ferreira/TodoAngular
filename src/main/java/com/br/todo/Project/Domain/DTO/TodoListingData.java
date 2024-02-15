package com.br.todo.Project.Domain.DTO;

import com.br.todo.Project.Domain.Todo;

import java.time.LocalDateTime;
import java.util.Date;

public record TodoListingData(String title, String description, Date completionDate, Boolean completed) {

    public TodoListingData(Todo todo){
        this(todo.getTitle(),
                todo.getDescription(),
                todo.getCompletionDate(),
                todo.getCompleted());
    }


}
