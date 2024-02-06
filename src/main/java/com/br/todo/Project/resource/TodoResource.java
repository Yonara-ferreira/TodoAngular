package com.br.todo.Project.resource;


import com.br.todo.Project.Domain.DTO.TodoCreatingData;
import com.br.todo.Project.Domain.DTO.TodoListingData;
import com.br.todo.Project.Domain.Todo;
import com.br.todo.Project.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @Operation(summary = "List all todo")
    @GetMapping(value = "/todo")
    public ResponseEntity<List<TodoListingData>> listAll(){
        List<TodoListingData> listAll = service.findAll();
        return (listAll != null) ? ResponseEntity.ok().body(listAll) : ResponseEntity.badRequest().build();
    }
    @Operation(summary = "Created new todo")
    @PostMapping(value = "/create")
    public ResponseEntity<TodoCreatingData> Create(@RequestBody TodoCreatingData todo,  @RequestParam(required = false) Integer id){
        TodoCreatingData createdTodo = service.create(todo, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);
    }

    @Operation(summary = "Delete todo")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteTodo(@PathVariable(value = "id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
