package com.example.demo.controller;

import com.example.demo.model.LibraryUser;
import com.example.demo.repository.ItemRepo;
import com.example.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepo userRepo;
    private final ItemRepo itemRepo;

    @GetMapping("/all")
    public List<LibraryUser> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<LibraryUser> returnLoanById(@PathVariable(name = "id") Long id) {
        return userRepo.findById(id);
    }
}
