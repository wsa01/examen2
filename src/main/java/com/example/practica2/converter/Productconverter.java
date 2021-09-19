package com.example.practica2.converter;

import com.example.practica2.bean.model.ProductModel;
import com.example.practica2.request.ProductReq;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class Productconverter implements Converter<ProductReq, ProductModel> {

    @Override
    public ProductModel convert(ProductReq source) {
        ProductModel productModel=new ProductModel();
        BeanUtils.copyProperties(source,productModel,"tyDoc");
        return productModel;
    }
}
