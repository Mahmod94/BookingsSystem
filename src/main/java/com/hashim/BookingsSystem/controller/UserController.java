package com.hashim.BookingsSystem.controller;

import com.hashim.BookingsSystem.model.User;
import com.hashim.BookingsSystem.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("api/users")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUser()
    {
        return this.userRepository.findAll();
    }

    @PostMapping("api/users")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<User> AddUser(@Valid @RequestBody User user){
        this.userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("api/users/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<User> deleteUser(@Valid @PathVariable  int id)
    {
        this.userRepository.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("api/users")
    void changePassword(@RequestBody User user)
    {

    }

}
