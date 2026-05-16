package com.hashim.BookingsSystem;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/users")
    public List<User> getAll()
    {
        return userRepo.findAll();
    }

    @PostMapping("/createUser")
    public String createUser(@RequestBody User user){
        userRepo.save(user);
        return user.toString();
    }


}
