package com.example.demo.controller;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.LibraryUser;
import com.example.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserRepo userRepo;

    @GetMapping("/all")
    public @ResponseBody List<LibraryUser> getAllUsers() {
        if (userRepo.count() > 0) {
            return userRepo.findAll();
        }else {
            throw new NotFoundException("No Users Found");
        }
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<LibraryUser> returnLoanById(@PathVariable(name = "id") Long id) {
        if (userRepo.existsById(id)) {
            return userRepo.findById(id);
        }else {
            throw new NotFoundException("User Not Found");
        }
    }
}
