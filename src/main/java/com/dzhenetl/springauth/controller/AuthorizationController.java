package com.dzhenetl.springauth.controller;

import com.dzhenetl.springauth.model.Authorities;
import com.dzhenetl.springauth.model.User;
import com.dzhenetl.springauth.service.AuthorizationService;
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
}