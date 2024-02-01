package com.br.todo.Project.resource;

import com.br.todo.Project.Domain.Todo;
import com.br.todo.Project.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/todos")
public class TodoResource {
    @Autowired
    private TodoService service;

    @Operation(summary = "Find todo for id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Todo> findById(@PathVariable(value = "id") Integer id) {
        Todo todo = service.findById(id);
        return (todo != null) ? ResponseEntity.ok().body(todo) : ResponseEntity.notFound().build();
    }
}
