package com.br.todo.Project.Domain.DTO;

import com.br.todo.Project.Domain.Todo;

public record TodoUpdateData(String title, String description, Boolean completed) {

    public TodoUpdateData(Todo todo){
        this(todo.getTitle(),
                todo.getDescription(),
                todo.getCompleted());
    }
}
