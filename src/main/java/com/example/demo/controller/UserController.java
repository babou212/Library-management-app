package com.example.demo.controller;

import com.example.demo.DTO.LibraryUserDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mappers.MapStructMapper;
import com.example.demo.model.LibraryUser;
import com.example.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserRepo userRepo;
    private final MapStructMapper mapStructMapper;

    @GetMapping("/all")
    public @ResponseBody List<LibraryUser> getAllUsers() {
        if (userRepo.count() > 0) {
            return userRepo.findAll();
        } else {
            throw new NotFoundException("No Users Found");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryUserDto>  returnUserById(@PathVariable(name = "id") Long id) {
        if (userRepo.existsById(id)) {
            return new ResponseEntity<>(
                    mapStructMapper.convert(userRepo.findById(id).get()),
                    HttpStatus.OK
            );
        } else {
            throw new NotFoundException("User Not Found");
        }
    }
}
