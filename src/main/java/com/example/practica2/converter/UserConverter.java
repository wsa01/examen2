package com.example.practica2.converter;

import com.example.practica2.bean.model.UserModel;
import com.example.practica2.request.UserReq;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<UserReq, UserModel> {
    @Override
    public UserModel convert(UserReq source) {
        UserModel userModel=new UserModel();
        BeanUtils.copyProperties(source,userModel,"tyDoc");
        return userModel;
    }
}
