package com.example.practica2.advice;

import com.example.practica2.enumeration.StatusEnum;
import com.example.practica2.exception.InvalidDataException;
import com.example.practica2.exception.ServException;
import com.example.practica2.response.StatusResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.rmi.ServerException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GeneralAdvice {


    @ExceptionHandler
    public ResponseEntity<?> ServException(ServException e){
        return ResponseEntity.badRequest().body(e.getStatusResponse());
    }
    @ExceptionHandler
    public ResponseEntity<?> InvalidDataExecption(InvalidDataException e){
        StatusResponse result= StatusEnum.ERROR_INVALID_DATA.getStatusResponse();
        List<String> erros=e.getResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        result.setErrors(erros);
        return ResponseEntity.badRequest().body(result);
    }
    @ExceptionHandler
    public ResponseEntity<?> ArgumentError(MethodArgumentTypeMismatchException e){
        StatusResponse result=StatusEnum.ERROR_INVALID_ARGUMENT.getStatusResponse();
        return ResponseEntity.badRequest().body(result);
    }
   @ExceptionHandler
   public ResponseEntity<?> GeneralExc(Exception e){
       StatusResponse result=StatusEnum.ERROR_GENERAL.getStatusResponse();
       return ResponseEntity.badRequest().body(result);
   }

}
