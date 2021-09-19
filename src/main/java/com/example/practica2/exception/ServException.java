package com.example.practica2.exception;

import com.example.practica2.enumeration.StatusEnum;
import com.example.practica2.response.StatusResponse;
import lombok.Getter;

@Getter
public class ServException extends Exception{

    private final StatusResponse statusResponse;

    public ServException(StatusEnum statusEnum) {
        this.statusResponse = statusEnum.getStatusResponse();
    }
}
