package com.dzhenetl.springauth.controller;

import com.dzhenetl.springauth.exception.InvalidCredentials;
import com.dzhenetl.springauth.exception.UnauthorizedUser;
import com.dzhenetl.springauth.model.Authorities;
import com.dzhenetl.springauth.model.User;
import com.dzhenetl.springauth.service.AuthorizationService;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities( user);
    }


    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedHandler(UnauthorizedUser e) {
        LoggerFactory.getLogger(UnauthorizedUser.class).warn(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentialsHandler(InvalidCredentials e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}