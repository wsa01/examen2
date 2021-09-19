package com.example.practica2.controller;

import com.example.practica2.bean.model.ProductModel;
import com.example.practica2.enumeration.StatusEnum;
import com.example.practica2.exception.InvalidDataException;
import com.example.practica2.exception.ServException;
import com.example.practica2.request.ProductEdithReq;
import com.example.practica2.request.ProductReq;
import com.example.practica2.response.GeneralResponse;
import com.example.practica2.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final Logger logger =LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private IProductService service;

    @GetMapping
    public ResponseEntity<?> listProducts() throws ServException {
        logger.info("Se entro a listar productos");
        List<ProductModel> result=service.lisProduct();
        return ResponseEntity.ok().body(new GeneralResponse<>(StatusEnum.OK.getStatusResponse(),result));
    }
    @PostMapping
    public ResponseEntity<?> addProduct(@Valid @RequestBody ProductReq productReq, BindingResult result) throws ServException, InvalidDataException {
        logger.info("Se entro a agregar productos");
        if (result.hasErrors()){throw new InvalidDataException(result);}
        service.addProduct(productReq);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<?> editProduct(@Valid @RequestBody ProductEdithReq productEdithReq, BindingResult result)throws ServException, InvalidDataException{
        logger.info("Se entro a editar productos");
        if (result.hasErrors()){throw new InvalidDataException(result);}
        service.editProduct(productEdithReq);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id)throws ServException{
        logger.info("Se borro un producto");
        service.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

}
