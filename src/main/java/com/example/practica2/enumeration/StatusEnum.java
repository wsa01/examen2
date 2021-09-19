package com.example.practica2.enumeration;

import com.example.practica2.response.StatusResponse;
import lombok.Getter;

@Getter
public enum StatusEnum {
    OK("8001","Proceso existoso"),
    ERROR_PRODUCT_NOT_EXIST("9001","El producto no existe"),
    ERROR_PRODUCT_EXIST("9002","El producto ya se encuentra registrado"),
    ERROR_DNI_EXIST("9003","El dni ya existe"),
    ERROR_CELLPHONE_EXIST("9004","el celular ya se encuentra registrado"),
    ERROR_USER_NOT_EXIST("9005","El usuario no existe"),
    ERROR_USER_EXIST("9006","El usuario ya existe"),
    ERROR_INVALID_DATA("9007","los datos son invalidos"),
    ERROR_INVALID_ARGUMENT("9008","El tipo de argumento es invalido"),
    ERROR_GENERAL("9009","No eres tu soy yo :_( ")
    ;

    private StatusResponse statusResponse;

    StatusEnum(String code, String message) {
        this.statusResponse = StatusResponse.builder().code(code).message(message).build();
    }
}
