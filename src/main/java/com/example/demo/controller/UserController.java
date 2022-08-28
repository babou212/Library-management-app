package com.example.demo.controller;

import com.example.demo.DTO.LibraryUserDto;
import com.example.demo.mapper.MapStructMapper;
import com.example.demo.model.LibraryUser;
import com.example.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserRepo userRepo;
    private final MapStructMapper mapStructMapper;

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<List<LibraryUser>> getAllUsers() {
        try {
            log.info("Executing GET request");
            return new ResponseEntity<>(userRepo.findAll(),
            HttpStatus.OK)
            ;
        } catch (Exception ex) {
            log.error("Error executing GET request: " + ex);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("get-user/{id}")
    public ResponseEntity<LibraryUserDto>  returnUserById(@PathVariable Long id) {
        try {
            log.info("Executing GET request");
            return new ResponseEntity<>(
                    mapStructMapper.convertUserToDto(userRepo.findById(id).get()),
                    HttpStatus.OK
            );
        } catch (Exception ex) {
            log.error("Error executing GET request: " + ex);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Void> createUser(@RequestBody LibraryUser user) {
        try {
            log.info("Executing POST request");
            userRepo.save(user);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            log.error("Error executing POST request: " + ex);
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("delete-user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try {
            log.info("Executing DELETE request");
            userRepo.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            log.error("Error executing DELETE request: " + ex);
            return ResponseEntity.internalServerError().build();
        }
    }
}
