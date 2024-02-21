package com.br.todo.Project.Domain.DTO;

import com.br.todo.Project.Domain.Todo;

public record TodoUpdateData(Integer id, String title, String description, Boolean completed) {

    public TodoUpdateData(Todo todo){
        this(todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getCompleted());
    }
}
