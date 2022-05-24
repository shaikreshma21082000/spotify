package com.niit.userauthentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT,reason = "User Already Exsists Exception")
public class UserAlreadyExsistException extends Exception {
}
