package com.example.secureapi.controller;

import com.example.secureapi.model.User;
import com.example.secureapi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@RestController
@RequestMapping("/api/data")
public class DataController {

    private final UserRepository userRepository;

    public DataController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        user.setUsername(HtmlUtils.htmlEscape(user.getUsername()));
        user.setEmail(HtmlUtils.htmlEscape(user.getEmail()));

        User savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}
