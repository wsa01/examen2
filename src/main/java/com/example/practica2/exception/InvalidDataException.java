package com.example.practica2.exception;

import org.springframework.validation.BindingResult;

public class InvalidDataException extends Exception{
    private final BindingResult result;

    public InvalidDataException(BindingResult result) {
        super();
        this.result = result;
    }
    public BindingResult getResult(){
        return result;
    }
}
