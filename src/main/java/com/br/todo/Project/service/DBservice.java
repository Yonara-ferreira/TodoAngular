package com.br.todo.Project.service;

import com.br.todo.Project.Domain.Todo;
import com.br.todo.Project.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class DBservice {

    @Autowired
    private TodoRepository todoRepository;

    public void instantiateDatabase(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Todo t1 = new Todo(null, "estudar", "Estudar Spring/Angular", LocalDateTime.parse("31/01/2024 23:25", formatter), false);
        todoRepository.saveAll(Arrays.asList(t1));
    }


}
