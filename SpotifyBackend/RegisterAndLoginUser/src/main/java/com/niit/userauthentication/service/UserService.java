package com.niit.userauthentication.service;

import com.niit.userauthentication.domain.User;
import com.niit.userauthentication.exception.InvalidCredentialsException;
import com.niit.userauthentication.exception.UserAlreadyExsistException;

import java.util.List;

public interface UserService {

    User saveUser(User user) throws UserAlreadyExsistException;
    public User findByUsernameAndPassword(String username , String password) throws InvalidCredentialsException;
    List<User> allUsers();
}