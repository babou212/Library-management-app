package com.example.demo.controller;

import com.example.demo.DTO.ItemDto;
import com.example.demo.mapper.MapStructMapper;
import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/items")
public class ItemController {
    private final ItemRepo itemRepo;

    private final UserRepo userRepo;

    private final ItemService itemService;
    private final MapStructMapper mapStructMapper;

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<List<Item>> getItems() {
        try {
            log.info("Executing GET request");
            return ResponseEntity.ok(itemRepo.findAll());
        } catch (Exception ex) {
            log.error("Error executing GET request: " + ex);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("get-item/{id}")
    public @ResponseBody ResponseEntity<ItemDto> returnItemById(@PathVariable Long id) {
        if (id != null && itemRepo.findById(id).isPresent()) {
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
        } return ResponseEntity.notFound().build();
    }

    @DeleteMapping("delete-item/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        Item filteredItem = itemRepo.findAll().stream().filter(item -> item.getId().equals(id)).reduce((a, b) -> {
            throw new IllegalStateException("Multiple elements found: " + a + b);
        }).get();

        if (userRepo.findAll().contains(filteredItem)) {
            try {
                log.info("Executing DELETE request");
                itemService.deleteItem(id);
                return ResponseEntity.ok().build();
                //  }
            } catch (Exception ex) {
                log.error("Executing DELETE request: " + ex);
                return ResponseEntity.internalServerError().build();
            }
        } return ResponseEntity.ok().build();
    }

    @PostMapping("add-new-item/{author}/{title}/{release}/{mediaType}/{isbn}")
    public ResponseEntity<HttpStatus> createItem(@PathVariable String author, @PathVariable String title,
            @PathVariable String release, @PathVariable String mediaType,@PathVariable @ISBN String isbn) {
        try {
            log.info("Executing POST request");
            itemService.createNewItem(author, title, release, mediaType, isbn);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            log.error("Error executing POST request:" + ex);
            return ResponseEntity.internalServerError().build();
        }
    }
}
