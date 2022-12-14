package com.example.demo.service;

import com.example.demo.model.Item;
import com.example.demo.model.MediaType;
import com.example.demo.repository.ItemRepo;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepo itemRepo;

    public void deleteItem(Long itemId) {
        if (itemRepo.findById(itemId).isPresent()) {
            if (!itemRepo.findById(itemId).get().isLoaned()) {
                Item item = itemRepo.findById(itemId).get();
                item.setAuthor(null);
                item.setTitle(null);
                item.setISBN(null);
                item.setYear(LocalDate.EPOCH);
                item.setMediaType(null);
                item.setLoaned(false);

                itemRepo.save(item);
            }
        }
    }

    public void createNewItem(String author, String title,
                             String release, String mediaType, @ISBN String isbn) {

        String media = mediaType.toUpperCase();

            MediaType mediaType1 = MediaType.valueOf(media);
            LocalDate releaseYear = LocalDate.parse(release);
            Item newItem = new Item(author, title, releaseYear, mediaType1, isbn, false);

            itemRepo.save(newItem);
    }
}
