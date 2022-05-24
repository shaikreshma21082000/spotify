package com.niit.userauthentication.service;

import com.niit.userauthentication.domain.User;
import com.niit.userauthentication.exception.InvalidCredentialsException;
import com.niit.userauthentication.exception.UserAlreadyExsistException;
import com.niit.userauthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user)throws UserAlreadyExsistException {
        System.out.println(user);
        return userRepository.save(user);

    }

    @Override
    public User findByUsernameAndPassword(String username, String password) throws InvalidCredentialsException {
        System.out.println("username"+username);
        System.out.println("password"+password);
        User loggedInUser = userRepository.findByUsernameAndPassword(username,password);
        System.out.println(loggedInUser);
        if(loggedInUser == null)
        {
            throw new InvalidCredentialsException();
        }
        return loggedInUser;
    }

    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }
}
