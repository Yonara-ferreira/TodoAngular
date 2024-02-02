package com.br.todo.Project.resource;


import com.br.todo.Project.Domain.DTO.TodoListingData;
import com.br.todo.Project.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/todos")
public class TodoResource {
    @Autowired
    private TodoService service;

    @Operation(summary = "Find todo for id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Integer id) {
        var todo =  service.findById(id);
        return (todo != null) ? ResponseEntity.ok().body(todo) : ResponseEntity.notFound().build();
    }
    @Operation(summary = "List all todo find where completed for false")
    @GetMapping(value="/open")
    public ResponseEntity<List<TodoListingData>> listOpen(){
        List<TodoListingData> findTodo = service.findAllOpen();
        return ResponseEntity.ok().body(findTodo);
    }
    @Operation(summary = "List all todo find where completed for true")
    @GetMapping(value="/close")
    public ResponseEntity<List<TodoListingData>> listClose(){
        List<TodoListingData> findTodo = service.findAllClose();
        return ResponseEntity.ok().body(findTodo);
    }
}
