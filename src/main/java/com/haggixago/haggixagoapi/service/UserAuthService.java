package com.haggixago.haggixagoapi.service;

import com.haggixago.haggixagoapi.model.UserAuth;

import java.util.List;

public interface UserAuthService {
    public UserAuth saveUser(UserAuth userAuth);
    public UserAuth getUserAuthByEmail(String email);
    public UserAuth getUserById(Integer id);
    public List<UserAuth> getUserList();
    public UserAuth updateUser(Integer id, UserAuth userAuth);
    public void deleteUserById(Integer id);
}
