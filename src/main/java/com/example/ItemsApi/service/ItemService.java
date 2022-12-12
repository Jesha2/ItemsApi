package com.example.ItemsApi.service;

import com.example.ItemsApi.controller.ItemController;
import com.example.ItemsApi.controller.ItemNotFoundException;
import com.example.ItemsApi.repository.ItemRepository;
import com.example.ItemsApi.repository.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ItemService
{
    private final ItemRepository itemRepository;

    public ItemService(@Autowired ItemRepository itemRepository )
    {
        this.itemRepository = itemRepository;
    }

    public List<Item> all()
    {
        //TODO implement this method
        return itemRepository.findAll();
    }

    // Method to getall with HATEAOs
    public CollectionModel<EntityModel<Item>> allHateaos() {

        List<EntityModel<Item>> items = itemRepository.findAll().stream()
                .map(item -> EntityModel.of(item,
                        linkTo(methodOn(ItemController.class).findItemById(item.getId())).withSelfRel(),
                        linkTo(methodOn(ItemController.class).getItems()).withRel("Items")))
                .collect(Collectors.toList());

        return CollectionModel.of(items, linkTo(methodOn(ItemController.class).getItems()).withSelfRel());
    }

    public Item save(Item item )
    {
        //TODO implement this method
        Item itemToSave = itemRepository.save(item);
        return itemToSave;
    }


    public void delete( int itemId )
    {
        //TODO implement this method
        itemRepository.deleteById(itemId);

    }

    public void deleteAll()
    {
        //TODO implement this method
        itemRepository.deleteAll();

    }
    public Item findItemById( int itemId )
    {
        //TODO implement this method
        //Item itemToFind =itemRepository.findById(itemId).get();
        return this.itemRepository.findById(itemId).get();
    }

// to be used if you want the hyperlinks
    public EntityModel<Item> findIemByIdH( int id) {

        Item item = itemRepository.findById(id) //
                .orElseThrow(() -> new ItemNotFoundException(id));

        return EntityModel.of(item, //
                linkTo(methodOn(ItemController.class).findItemById(id)).withSelfRel(),
                linkTo(methodOn(ItemController.class).getItems()).withRel("Items"));
    }


    //    public Item findItemByCategory( String category )
//    {
//        //TODO implement this method
//        Item ItemToFind =itemRepository.findItemByCategory(category);
//        return ItemToFind;
//    }
    //    public CollectionModel<EntityModel<Item>> getItemsByCategory(String category) {
//
//       // Item items = itemRepository.findItemByCategory(category);
//        List<EntityModel<Item>> items =  itemRepository.findItemsByCategory( category);
//
//        return CollectionModel.of(items, linkTo(methodOn(ItemController.class).getItems()).withSelfRel());
//    }
}
