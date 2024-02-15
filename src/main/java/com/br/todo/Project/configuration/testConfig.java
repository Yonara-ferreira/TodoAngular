package com.br.todo.Project.configuration;

import com.br.todo.Project.service.DBservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
public class testConfig {

    @Autowired
    private DBservice dBservice;

    // TODO: 31/01/2024   foi criado esse perfil para cada vez que o 'perfil' estiver
    //  ativo o mesmo possa ser instanciado com a base de dados;

    @Bean
    public  boolean instancia() throws ParseException {
        this.dBservice.instantiateDatabase();
        return true;
    }


}
