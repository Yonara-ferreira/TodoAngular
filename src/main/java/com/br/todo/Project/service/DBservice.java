package com.br.todo.Project.service;

import com.br.todo.Project.Domain.Todo;
import com.br.todo.Project.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Service
public class DBservice {

    @Autowired
    private TodoRepository todoRepository;

    public void instantiateDatabase() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Todo t1 = new Todo(null, "estudar", "Estudar Spring/Angular", sdf.parse("25/03/2022"), false);
        Todo t2 = new Todo(null, "Academia", "Treino superiores", sdf.parse("02/02/2024"), true);
        Todo t3 = new Todo(null, "netflix", "Assistir Ben 10", sdf.parse("02/02/2024"), true);
        Todo t4 = new Todo(null, "Desenhar", "Fazer quadro do Zuko", sdf.parse("02/02/2024"), true);
        Todo t5 = new Todo(null, "Correr", "Correr 20 kilometros ", sdf.parse("27/09/2021"), false);
        Todo t6 = new Todo(null, "Trabalho", "Trabalho da faculdade para apresentar", sdf.parse("27/05/2021"), false);
        todoRepository.saveAll(Arrays.asList(t1,t2,t3,t4,t5,t6));
    }


}
