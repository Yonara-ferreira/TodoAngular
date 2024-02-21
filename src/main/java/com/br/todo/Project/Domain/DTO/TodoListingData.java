package com.br.todo.Project.Domain.DTO;

import com.br.todo.Project.Domain.Todo;


import java.util.Date;

public record TodoListingData(Integer id, String title, String description, Date completionDate, Boolean completed) {

    public TodoListingData(Todo todo){
        this(todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getCompletionDate(),
                todo.getCompleted());
    }

}
