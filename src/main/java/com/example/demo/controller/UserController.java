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

import javax.validation.constraints.Email;
import java.util.HashSet;
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
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("get-user/{id}")
    public ResponseEntity<LibraryUserDto>  returnUserById(@PathVariable String id) {
        try {
            log.info("Executing GET request");
            return new ResponseEntity<>(
                    mapStructMapper.convertUserToDto(userRepo.findById(Long.valueOf(id)).get()),
                    HttpStatus.OK
            );
        } catch (Exception ex) {
            log.error("Error executing GET request: " + ex);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("create-new-user/{firstName}/{lastName}/{email}")
    public ResponseEntity<HttpStatus> createUser(@PathVariable String firstName, @PathVariable String lastName,
                                           @PathVariable @Email String email) {
        try {
            log.info("Executing POST request");
            LibraryUser receivedUser = new LibraryUser(firstName, lastName, email, new HashSet<>());
            userRepo.save(receivedUser);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            log.error("Error executing POST request: " + ex);
            return ResponseEntity.internalServerError().build();
        }
    }
}
