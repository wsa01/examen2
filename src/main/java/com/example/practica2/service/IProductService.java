package com.example.practica2.service;

import com.example.practica2.bean.model.ProductModel;
import com.example.practica2.exception.ServException;
import com.example.practica2.request.ProductEdithReq;
import com.example.practica2.request.ProductReq;

import java.util.List;

public interface IProductService {

    public List<ProductModel> lisProduct()throws ServException;
    public void addProduct(ProductReq productReq)throws ServException;
    public void editProduct(ProductEdithReq productEdithReq)throws ServException;
    public void deleteProduct(int id)throws ServException;

}
