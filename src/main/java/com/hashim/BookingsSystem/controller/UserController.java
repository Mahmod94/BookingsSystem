package com.hashim.BookingsSystem.controller;

import com.hashim.BookingsSystem.model.RegisterRequest;
import com.hashim.BookingsSystem.model.Role;
import com.hashim.BookingsSystem.model.User;
import com.hashim.BookingsSystem.repository.UserRepository;
import com.hashim.BookingsSystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserRepository userRepository;
    private UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("api/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest registerRequest)
    {
        return  this.userService.registerNewUser(registerRequest);
    }


    @GetMapping("api/users")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUser()
    {
        return this.userRepository.findAll();
    }


































    @DeleteMapping("api/users/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<User> deleteUser(@Valid @PathVariable long id)
    {
        this.userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("api/users")
    void changePassword(@RequestBody User user)
    {

    }

}
