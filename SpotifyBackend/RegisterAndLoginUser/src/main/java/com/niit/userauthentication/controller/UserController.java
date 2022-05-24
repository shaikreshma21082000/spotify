package com.niit.userauthentication.controller;


import com.niit.userauthentication.domain.User;
import com.niit.userauthentication.exception.InvalidCredentialsException;
import com.niit.userauthentication.exception.UserAlreadyExsistException;
import com.niit.userauthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins="*")
public class UserController {
    private ResponseEntity responseEntity;
    private UserService userService;

    @Autowired
    public UserController(UserService userService )
    {
        this.userService = userService;
    }


    //Should only give username and password
    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody User user) throws InvalidCredentialsException {
        try {
            User userObj = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
            responseEntity = new ResponseEntity(user, HttpStatus.OK);
        }
        catch(InvalidCredentialsException e){
            throw new InvalidCredentialsException();
        }
        catch (Exception e){
            responseEntity = new ResponseEntity("Try after sometime!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


    @PostMapping("/register")
    public ResponseEntity saveUser(@RequestBody User user)throws UserAlreadyExsistException {
       try{
           User createdUser = userService.saveUser(user);
           System.out.println("entered into controller register");
           responseEntity = new ResponseEntity(user,HttpStatus.OK);
    }
    catch(UserAlreadyExsistException e){
        throw new UserAlreadyExsistException();
    }
    return responseEntity;
}

@GetMapping("/users")
public ResponseEntity getUsers(){
    responseEntity = new ResponseEntity(userService.allUsers(),HttpStatus.OK);
    return responseEntity;
}

}
