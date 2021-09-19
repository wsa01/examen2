package com.example.practica2.service;

import com.example.practica2.bean.model.UserModel;
import com.example.practica2.exception.ServException;
import com.example.practica2.request.UserEditReq;
import com.example.practica2.request.UserReq;

import java.util.List;

public interface IUserService {

    public List<UserModel> listUser()throws ServException;
    public void addUser(UserReq userReq)throws ServException;
    public void deleteUser(int id)throws ServException;
    public void editUser(UserEditReq userEditReq)throws ServException;
}
