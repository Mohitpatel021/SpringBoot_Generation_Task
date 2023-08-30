package com.itemapplication.application.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itemapplication.application.Model.Item;
import com.itemapplication.application.Repositiory.ItemRepository;

import java.util.List;

@Service
public class ItemServiceMySQL implements ItemService {

    private final ItemRepository itemRepository;

  
    public ItemServiceMySQL( @Autowired ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void delete(int itemId) {
        itemRepository.deleteById(itemId);
    }

    @Override
    public List<Item> all() {
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    public Item findById(int itemId) {
        return itemRepository.findById(itemId).orElse(null);
    }
}
