package com.example.demo.controller;

import com.example.demo.DTO.ItemDto;
import com.example.demo.mapper.MapStructMapper;
import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/items")
public class ItemController {
    private final ItemRepo itemRepo;
    private final MapStructMapper mapStructMapper;

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<List<Item>> getItems() {
        try {
            log.info("Executing GET request");
            return ResponseEntity.ok(itemRepo.findAll());
        } catch (Exception ex) {
            log.error("Error executing GET request: " + ex);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<ItemDto> returnItemById(@PathVariable Long id) {
        try {
            log.info("Executing GET request");
            return new ResponseEntity<>(
                    mapStructMapper.convertItemToDto(itemRepo.findById(id).get()),
                    HttpStatus.OK
            );
        } catch (Exception ex) {
            log.error("Error executing GET request: " + ex);
            return ResponseEntity.internalServerError().build();
        }
    }
}
