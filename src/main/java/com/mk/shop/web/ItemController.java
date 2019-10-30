package com.mk.shop.web;

import com.mk.shop.domain.Item;
import com.mk.shop.repositories.ItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("api")
public class ItemController {
    private static final String ENTITY_NAME = "Item";

    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostMapping("/items")
    public ResponseEntity<Item> createItem(@RequestBody Item item) throws Exception {
        if (item.getId() != null) throw new Exception();
        Item result = itemRepository.save(item);
        return ResponseEntity.created(new URI("/api/items" + result.getId())).body(result);

    }
}
