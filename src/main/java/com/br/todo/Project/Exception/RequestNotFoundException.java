package com.br.todo.Project.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Order")
public class RequestNotFoundException extends RuntimeException{
    private String msg;

    public RequestNotFoundException(String msg) {
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }
}
