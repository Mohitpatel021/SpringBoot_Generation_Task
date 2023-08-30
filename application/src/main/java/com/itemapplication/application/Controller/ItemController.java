package com.itemapplication.application.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.itemapplication.application.Controller.DTO.ItemDto;
import com.itemapplication.application.Model.Item;
import com.itemapplication.application.Service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

  
    public ItemController(  @Autowired ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/all")
    public List<Item> getItems() {
        return itemService.all();
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Item> saveItem(@RequestBody  ItemDto itemDto) {
        Item newItem = new Item(itemDto.getName(), itemDto.getDescription(), itemDto.getImageUrl());
        Item savedItem = itemService.save(newItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable int id) {
        Item item = itemService.findById(id);
        if (item != null) {
            return ResponseEntity.ok(item);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@RequestBody ItemDto itemDto, @PathVariable int id) {
        Item item = itemService.findById(id);
        if (item != null) {
            item.setName(itemDto.getName());
            item.setDescription(itemDto.getDescription());
            item.setImageUrl(itemDto.getImageUrl());
            Item updatedItem = itemService.save(item);
            return ResponseEntity.ok(updatedItem);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable int id) {
        itemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

