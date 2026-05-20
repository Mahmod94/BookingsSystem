package com.hashim.BookingsSystem.controller;

import com.hashim.BookingsSystem.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private AuthenticationManager authManager;

    private JwtService jwtService;

}
