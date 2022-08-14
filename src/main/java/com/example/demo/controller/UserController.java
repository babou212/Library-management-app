package com.example.demo.controller;

import com.example.demo.model.LibraryUser;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @GetMapping("/all")
    public Set<LibraryUser> getAllUsers() {
        return userService.findAll();
    }
}
