package com.example.practica2.service.impl;

import com.example.practica2.bean.model.UserModel;
import com.example.practica2.controller.ProductController;
import com.example.practica2.converter.UserConverter;
import com.example.practica2.converter.UserEditConverter;
import com.example.practica2.enumeration.StatusEnum;
import com.example.practica2.exception.ServException;
import com.example.practica2.repository.UserRepository;
import com.example.practica2.request.UserEditReq;
import com.example.practica2.request.UserReq;
import com.example.practica2.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository repo;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private UserEditConverter userEditConverter;



    @Override
    public List<UserModel> listUser() {
        return repo.findAll();
    }

    @Override
    public void addUser(UserReq userReq) throws ServException {
        UserModel userModel=userConverter.convert(userReq);
        List<UserModel> users=repo.findAll();
        //valida existencia de DNI
        boolean dniExist= users.stream()
                .map(UserModel::getDni)
                .anyMatch(e->e.equals(userModel.getDni()));
        if (dniExist){throw new ServException(StatusEnum.ERROR_DNI_EXIST);}
        //valida existencia de celular
        boolean cellExist=users.stream()
                .map(UserModel::getCellphone)
                .anyMatch(e->e.equals(userModel.getCellphone()));
        if (cellExist){throw new ServException(StatusEnum.ERROR_CELLPHONE_EXIST);}

        assert userModel != null;
        repo.save(userModel);
    }

    @Override
    public void deleteUser(int id) throws ServException {
        UserModel find= repo.findById(id).orElse(null);
        if (find==null){throw new ServException(StatusEnum.ERROR_USER_NOT_EXIST);}
        repo.deleteById(id);
    }

    @Override
    public void editUser(UserEditReq userEditReq) throws ServException{
       UserModel userModel=userEditConverter.convert(userEditReq);
        assert userModel != null;
        UserModel find= repo.findById(userModel.getId()).orElse(null);
        if (find==null){throw new ServException(StatusEnum.ERROR_USER_NOT_EXIST);}
        repo.save(userModel);
    }
}
