package com.itemapplication.application.Repositiory;

import org.springframework.data.repository.CrudRepository;

import com.itemapplication.application.Model.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {
}

