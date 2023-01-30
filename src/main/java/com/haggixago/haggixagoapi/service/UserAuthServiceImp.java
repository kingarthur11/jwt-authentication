package com.haggixago.haggixagoapi.service;

import com.haggixago.haggixagoapi.model.UserAuth;
import com.haggixago.haggixagoapi.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAuthServiceImp implements UserAuthService {

    @Autowired
    UserAuthRepository userAuthRepository;
    @Override
    public UserAuth saveUser(UserAuth userAuth) {
        return userAuthRepository.save(userAuth);
    }

    @Override
    public UserAuth getUserAuthByEmail(String email) {
        return userAuthRepository.findUserAuthByEmail(email);
    }

    @Override
    public UserAuth getUserById(Integer id) {
        return userAuthRepository.findById(id).get();
    }

    @Override
    public List<UserAuth> getUserList() {
        return null;
    }

    @Override
    public UserAuth updateUser(Integer id, UserAuth userAuth) {
        return null;
    }

    @Override
    public void deleteUserById(Integer id) {

    }
}
