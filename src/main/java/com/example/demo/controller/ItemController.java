package com.example.demo.controller;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/item")
public class ItemController {
    private final ItemRepo itemRepo;

    @GetMapping("/all")
    public @ResponseBody List<Item> listAllItems() {
        if (itemRepo.count() > 0) {
            return itemRepo.findAll();
        }else {
            throw new NotFoundException("No Loans Found");
        }
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Item> returnLoanById(@PathVariable(name = "id") Long id) {
        if (itemRepo.existsById(id)) {
            return itemRepo.findById(id);
        } else {
            throw new NotFoundException("Loan Not Found");
        }
    }
}
