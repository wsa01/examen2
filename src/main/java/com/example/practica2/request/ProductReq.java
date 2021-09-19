package com.example.practica2.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductReq {
    @NotEmpty(message = "El nombre no puede estar vacio")
    private String nombre;
    @Min(value = 0,message = "El precio minimo es cero")
    @Max(value = 1000,message = "El precio maximo es 1000 soles")
    private long precio;
}
