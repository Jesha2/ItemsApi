package com.example.ItemsApi.repository;


import com.example.ItemsApi.repository.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.hateoas.EntityModel;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called itemRepository
    // CRUD refers Create, Read, Update, Delete
    public interface ItemRepository extends JpaRepository<Item, Integer>
    {
        //public Item findItemByCategory(String category);
        //public List<EntityModel<Item>>  findItemsByCategory(String category);
    }