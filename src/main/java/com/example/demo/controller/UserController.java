package com.example.demo.controller;

import com.example.demo.DTO.LibraryUserDto;
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
        } catch (Exception ex){
            log.error("Error during get request: " + ex);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryUserDto>  returnUserById(@PathVariable(name = "id") Long id) {
        try {
            log.info("Executing GET request");
            return new ResponseEntity<>(
                    mapStructMapper.convert(userRepo.findById(id).get()),
                    HttpStatus.OK
            );
        } catch (Exception ex){
            log.error("Error during get request" + ex);
            return ResponseEntity.internalServerError().build();
        }
    }
}
