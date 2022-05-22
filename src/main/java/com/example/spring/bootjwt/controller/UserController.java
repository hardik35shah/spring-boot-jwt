package com.example.spring.bootjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @GetMapping("/principal")
    public String retrievePrincipal(Principal principal) {
       String name=principal.getName();
        return name;
    }
}
