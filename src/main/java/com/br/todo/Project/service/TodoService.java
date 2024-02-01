package com.br.todo.Project.service;

import com.br.todo.Project.Domain.DTO.TodoListingData;
import com.br.todo.Project.Domain.Todo;
import com.br.todo.Project.Exception.RequestNotFoundException;
import com.br.todo.Project.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository respository;

    public Object findById(Integer id) {
        Todo todos = respository.findById(id).orElseThrow(() -> new RequestNotFoundException("Todo not found for:" + id));
        return new TodoListingData(todos);

    }

}
