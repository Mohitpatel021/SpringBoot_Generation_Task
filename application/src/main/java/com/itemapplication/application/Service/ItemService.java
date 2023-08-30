package com.itemapplication.application.Service;

import java.util.List;

import com.itemapplication.application.Model.Item;

public interface ItemService {

    Item save(Item item);

    void delete(int itemId);

    List<Item> all();

    Item findById(int itemId);

}

