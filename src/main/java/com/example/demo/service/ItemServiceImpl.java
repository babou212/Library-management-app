package com.example.demo.service;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepo itemRepo;

    @Override
    public Set<Item> findAll() {
        return (Set<Item>) itemRepo.findAll();
    }

    @Override
    public Item findById(Long aLong) {
        return itemRepo.findById(aLong).orElse(null);
    }

    @Override
    public Item save(Item object) {
        return itemRepo.save(object);
    }

    @Override
    public void delete(Item object) {
        itemRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        itemRepo.deleteById(aLong);
    }
}
