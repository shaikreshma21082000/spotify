package com.niit.usersongs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT , reason = "playlist already exists")
public class PlaylistAlreadyExsistException extends Exception {
}
