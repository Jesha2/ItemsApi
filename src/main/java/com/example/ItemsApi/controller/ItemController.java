package com.example.ItemsApi.controller;

import com.example.ItemsApi.repository.entity.Item;
import com.example.ItemsApi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController{
    final ItemService itemService;
    public ItemController( @Autowired ItemService itemService )
    {
        this.itemService = itemService;
    }

    @CrossOrigin
    @GetMapping( "/all" )
    public Iterable<Item> getItems()
    {
        return itemService.all();
    }

    @CrossOrigin
    @PostMapping
    public Item save( @RequestBody ItemDto itemDto )
    {
        return itemService.save( new Item( itemDto) );
    }

    @GetMapping( "/{id}" )//To find an item by Id
    public Item findItemById( @PathVariable Integer id )
    {
        return itemService.findItemById( id );
    }

    @PutMapping( "/{id}" )// to update an item when the id and the itemDTO is available
    public Item update( @RequestBody ItemDto itemDto, @PathVariable Integer id )
    {
       Item  item = itemService.findItemById( id );
       item.setCategory(itemDto.getCategory());
        item.setName( itemDto.getName() );
        item.setDescription( itemDto.getDescription() );
        item.setImageUrl( itemDto.getImageUrl() );
        item.setPrice(itemDto.getPrice());
        item.setQuantity(itemDto.getQuantity());
        item.setSize(itemDto.getSize());
        return itemService.save( item );
    }

    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        itemService.delete( id );
    }
    @DeleteMapping
    public void deleteAll( )
    {
        itemService.deleteAll();
    }

     //          ***************HATEOAS***************   //
     @CrossOrigin
     @GetMapping( "/allH" )// get the items with Hateoas by appending the endpoint with H
     public CollectionModel<EntityModel<Item>> getItemsH() {
         return itemService.allHateoas();
     }

    @GetMapping( "/{id}H" )// get an item by id with Hateoas by appending the endpoint with H
    public EntityModel<Item> findItemByIdH( @PathVariable Integer id )
    {
        return itemService.findIemByIdH( id );
    }

}