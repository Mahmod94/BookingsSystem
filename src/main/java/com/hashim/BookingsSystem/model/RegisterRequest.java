package com.hashim.BookingsSystem.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequest {
    @NotBlank(message = "Username is required")
    @Size(min = 2, max = 20, message = "username must be between 2 and 20")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 5 characters")
    private String password;
    private Role role;

    public RegisterRequest(String username, String password) {
        this.username = username;
        this.password = password;
        role = Role.USER;
    }

    public RegisterRequest() {    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
