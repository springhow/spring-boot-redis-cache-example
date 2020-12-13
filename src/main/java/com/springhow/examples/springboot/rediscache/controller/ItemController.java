package com.springhow.examples.springboot.rediscache.controller;

import com.springhow.examples.springboot.rediscache.entities.Item;
import com.springhow.examples.springboot.rediscache.service.ItemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/items/")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable Integer id) {
        return itemService.getItem(id);
    }

    @PostMapping("/")
    public Item createItem(@RequestBody Item request) {
        return itemService.createItem(request);
    }

    @PutMapping("/{id}")
    public Item createItem(@PathVariable Integer id, @RequestBody Item request) {
        return itemService.updateItem(id, request);
    }
}
