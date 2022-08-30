package com.example.demo.service;

import com.example.demo.repository.ItemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepo itemRepo;

    public void deleteItem(Long itemId) {
        if (!itemRepo.findById(itemId).get().isLoaned()) {
            itemRepo.deleteById(itemId);
        }
    }
}
