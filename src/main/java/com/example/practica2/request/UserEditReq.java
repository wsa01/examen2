package com.example.practica2.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEditReq {
    @NotNull
    private int id;
    @NotEmpty(message = "El nombre no puede estar vacio")
    private String name;
    @Pattern(regexp = "[0-9]{8}",message = "El DNI debe tener 8 digitos")
    private String dni;
    @Pattern(regexp = "[0-9]{9}",message = "El celular debe tener 9 digitos")
    private String cellphone;
}
