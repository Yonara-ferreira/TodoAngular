package com.br.todo.Project.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT, reason="Duplicate")
public class DuplicateRequestException extends RuntimeException{
    private String msg;

    public DuplicateRequestException(String msg) {
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }

}
