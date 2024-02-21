package com.br.todo.Project.service;

import com.br.todo.Project.Domain.DTO.TodoCreatingData;
import com.br.todo.Project.Domain.DTO.TodoListingData;
import com.br.todo.Project.Domain.DTO.TodoUpdateData;
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

    public TodoListingData findById(Integer id) {
        Todo todos = repository.findById(id).orElseThrow(() ->
                new RequestNotFoundException("Todo not found for: " + id + ", type: " + Todo.class.getName()));
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

    public TodoListingData update(TodoUpdateData todoUpdateData, Integer id) {
        try{
            Todo todo = repository.getReferenceById(id);
            todo.setTitle(todoUpdateData.title());
            todo = repository.save(todo);
            return new TodoListingData(todo);
        }catch (RequestNotFoundException e){
            throw new RequestNotFoundException("id not found " + id);
        }
    }

    /*@Autowired
    private TodoRepository repository;

    public Todo findById(Integer id) {
        Optional<Todo> obj = repository.findById(id);
        return obj.orElseThrow(() -> new RequestNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Todo.class.getName()));
    }

    public List<Todo> findAllOpen() {
        List<Todo> list = repository.findAllOpen();
        return list;
    }

    public List<Todo> findAllClose() {
        List<Todo> list = repository.findAllClose();
        return list;
    }

    public List<Todo> findAll() {
        List<Todo> list = repository.findAll();
        return list;
    }

    public Todo create(Todo obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Todo update(Integer id, Todo obj) {
        Todo newObj = findById(id);
        newObj.setTitle(obj.getTitle());
        newObj.setCompletionDate(obj.getCompletionDate());
        newObj.setDescription(obj.getDescription());
        newObj.setCompleted(obj.getCompleted());
        return repository.save(newObj);
    }*/

}
