package com.br.todo.Project.service;

import com.br.todo.Project.Domain.DTO.TodoCreatingData;
import com.br.todo.Project.Domain.DTO.TodoListingData;
import com.br.todo.Project.Domain.Todo;
import com.br.todo.Project.Exception.RequestNotFoundException;
import com.br.todo.Project.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public Object findById(Integer id) {
        Todo todos = repository.findById(id).orElseThrow(() -> new RequestNotFoundException("Todo not found for:" + id + ", type: " + Todo.class.getName()));
        return new TodoListingData(todos);

    }

    public List<TodoListingData> findAllOpen(){
        return repository.findAllOpen()
                .stream()
                .map(TodoListingData::new)
                .toList();
    }

    public List<TodoListingData> findAllClose(){
        return repository.findAllClose()
                .stream()
                .map(TodoListingData::new)
                .toList();
    }


    public List<TodoListingData> findAll() {
        return repository.findAll()
                .stream()
                .map(TodoListingData::new)
                .toList();
    }

    public TodoCreatingData create(TodoCreatingData todoCreatingData, Integer id) {
        Optional<Todo> existingTodo = repository.findById(todoCreatingData.id());
        if(!existingTodo.isPresent()){
            Todo todo = new Todo(todoCreatingData);
            repository.save(todo);
            return new TodoCreatingData(todo);
        }else{
            throw new RuntimeException();
        }

    }
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
