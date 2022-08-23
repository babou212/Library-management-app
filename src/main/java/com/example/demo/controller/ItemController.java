package com.example.demo.controller;

import com.example.demo.DTO.ItemDto;
import com.example.demo.mappers.MapStructMapper;
import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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
        } catch (Exception ex){
            log.error("Error during get request: " + ex);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<ItemDto> returnItemById(@PathVariable(name = "id") Long id) {
        try {
            log.info("Executing GET request");
            return new ResponseEntity<>(
                    mapStructMapper.convert(itemRepo.findById(id).get()),
                    HttpStatus.OK
            );
        } catch (Exception ex){
            log.error("Error during get request: " + ex);
            return ResponseEntity.internalServerError().build();
        }
    }
}
