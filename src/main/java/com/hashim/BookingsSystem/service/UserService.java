package com.hashim.BookingsSystem.service;

import com.hashim.BookingsSystem.exception.UserAlreadyExistsException;
import com.hashim.BookingsSystem.model.RegisterRequest;
import com.hashim.BookingsSystem.model.Role;
import com.hashim.BookingsSystem.model.User;
import com.hashim.BookingsSystem.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<User> registerNewUser(RegisterRequest registerRequest)
    {
        if (userRepository.findByUsername(registerRequest.getUsername()).isPresent())
            throw new UserAlreadyExistsException(
                    "Username " + registerRequest.getUsername() + " is already taken"
            );

        User user = new User(registerRequest.getUsername(), passwordEncoder.encode(registerRequest.getPassword()), Role.USER);
        this.userRepository.save(user);
        return ResponseEntity.ok(user);
    }
}
