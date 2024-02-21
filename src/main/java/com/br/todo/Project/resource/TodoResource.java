package com.br.todo.Project.resource;


import com.br.todo.Project.Domain.DTO.TodoCreatingData;
import com.br.todo.Project.Domain.DTO.TodoListingData;
import com.br.todo.Project.Domain.DTO.TodoUpdateData;
import com.br.todo.Project.Domain.Todo;
import com.br.todo.Project.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin("*")
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
    @GetMapping
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
    @Operation(summary = "Update todo")
    @PutMapping("/{id}")
    public ResponseEntity<TodoListingData> UpdateTodo(@RequestBody TodoUpdateData todo, @PathVariable(value = "id") Integer id){
        TodoListingData newObj = service.update(todo, id);
        return ResponseEntity.ok().body(newObj);
    }
/*    @Autowired*/
    /*private TodoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Integer id) {
        Todo obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/open")
    public ResponseEntity<List<Todo>> listOpen() {
        List<Todo> list = service.findAllOpen();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/close")
    public ResponseEntity<List<Todo>> listClose() {
        List<Todo> list = service.findAllClose();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> listAll() {
        List<Todo> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo obj) {
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Todo> update(@PathVariable Integer id, @RequestBody Todo obj) {
        Todo newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }
*/
}
