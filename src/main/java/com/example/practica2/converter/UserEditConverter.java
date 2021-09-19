package com.example.practica2.converter;

import com.example.practica2.bean.model.UserModel;
import com.example.practica2.request.UserEditReq;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserEditConverter implements Converter<UserEditReq, UserModel> {
    @Override
    public UserModel convert(UserEditReq source) {
        UserModel userModel=new UserModel();
        BeanUtils.copyProperties(source,userModel,"tyDoc");
        return userModel;
    }
}
