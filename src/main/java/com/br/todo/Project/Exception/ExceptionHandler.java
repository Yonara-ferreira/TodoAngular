package com.br.todo.Project.Exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionHandler {
    private String msg;
    private Integer codeStatus;

    public ExceptionHandler(String msg, Integer codeStatus){
        this.msg = msg;
        this.codeStatus = codeStatus;
    }
}
