package com.stackroute.springboot.service;

import com.stackroute.springboot.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();

    public void deleteUser(int id) throws Exception;
    User updateUser(User user) throws Exception;
}
