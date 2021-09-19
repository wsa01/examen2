package com.example.practica2.service.impl;

import com.example.practica2.bean.model.ProductModel;
import com.example.practica2.controller.ProductController;
import com.example.practica2.converter.ProductEditConverter;
import com.example.practica2.converter.Productconverter;
import com.example.practica2.enumeration.StatusEnum;
import com.example.practica2.exception.ServException;
import com.example.practica2.repository.ProductRepository;
import com.example.practica2.request.ProductEdithReq;
import com.example.practica2.request.ProductReq;
import com.example.practica2.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {


    @Autowired
    private ProductRepository repo;
    @Autowired
    private Productconverter productconverter;
    @Autowired
    private ProductEditConverter productEditConverter;

    @Override
    public List<ProductModel> lisProduct() {
        return repo.findAll();
    }

    @Override
    public void addProduct(ProductReq productReq) throws ServException {
        ProductModel productModel=productconverter.convert(productReq);
        assert productModel != null;
        boolean compare=repo.findAll().stream()
                        .anyMatch(p->p.getNombre().equals(productModel.getNombre()));
        //se valida producto con el mismo nombre
        if (compare){throw new ServException(StatusEnum.ERROR_PRODUCT_EXIST);}
        repo.save(productModel);
    }

    @Override
    public void editProduct(ProductEdithReq productEdithReq)throws ServException {
        ProductModel productModel=productEditConverter.convert(productEdithReq);
        assert productModel != null;
        ProductModel find= repo.findById(productModel.getCode()).orElse(null);
        if (find==null){throw new ServException(StatusEnum.ERROR_PRODUCT_NOT_EXIST);}
        repo.save(productModel);
    }

    @Override
    public void deleteProduct(int id) throws ServException{
        ProductModel find=repo.findById(id).orElse(null);
        if (find==null){throw new ServException(StatusEnum.ERROR_PRODUCT_NOT_EXIST);}
        repo.deleteById(id);
    }
}
