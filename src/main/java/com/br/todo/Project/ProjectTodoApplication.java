package com.br.todo.Project;


import com.br.todo.Project.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectTodoApplication implements CommandLineRunner {

    @Autowired
    private TodoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjectTodoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }

    /*documentaçao SWAGGER*/
    /*http://localhost:5050/swagger-ui/index.html*/

}
