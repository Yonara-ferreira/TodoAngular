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
        Todo t2 = new Todo(null, "Academia", "Treino superiores", LocalDateTime.parse("02/02/2024 10:25", formatter), true);
        Todo t3 = new Todo(null, "netflix", "Assistir Ben 10", LocalDateTime.parse("02/02/2024 10:25", formatter), true);
        Todo t4 = new Todo(null, "Desenhar", "Fazer quadro do Zuko", LocalDateTime.parse("02/02/2024 10:25", formatter), false);
        todoRepository.saveAll(Arrays.asList(t1,t2,t3,t4));
    }


}
