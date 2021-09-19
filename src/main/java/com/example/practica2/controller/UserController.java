package com.example.practica2.controller;

import com.example.practica2.bean.model.UserModel;
import com.example.practica2.enumeration.StatusEnum;
import com.example.practica2.exception.InvalidDataException;
import com.example.practica2.exception.ServException;
import com.example.practica2.request.UserEditReq;
import com.example.practica2.request.UserReq;
import com.example.practica2.response.GeneralResponse;
import com.example.practica2.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private IUserService service;

    @GetMapping
    public ResponseEntity<?> listUsers() throws ServException {
        List<UserModel> result=service.listUser();
        logger.info("Se listo usuarios");
        return ResponseEntity.ok().body(new GeneralResponse<>(StatusEnum.OK.getStatusResponse(),result));
    }
    @PostMapping
    public ResponseEntity<?> addUser(@Valid @RequestBody UserReq userReq, BindingResult result)throws ServException, InvalidDataException{
        if (result.hasErrors()){logger.error("error de datos invalido");throw new InvalidDataException(result);}
        service.addUser(userReq);
        logger.info("Se agrego al usuario :"+userReq.getName());
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<?> editUser(@Valid @RequestBody UserEditReq userEditReq, BindingResult result)throws ServException, InvalidDataException {
        if (result.hasErrors()){logger.error("error de datos invalido");throw new InvalidDataException(result);}
        service.editUser(userEditReq);
        logger.info("Se edito un usuario");
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id)throws ServException{
        service.deleteUser(id);
        logger.info("Se elimino un usuario");
        return ResponseEntity.ok().build();
    }
}
