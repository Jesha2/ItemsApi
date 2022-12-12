package com.example.ItemsApi.controller;

//import com.example.ItemsApi.repository.ItemRepository;

import com.example.ItemsApi.repository.entity.Item;
import com.example.ItemsApi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/item")
public class ItemController{

//    final ItemRepository itemRepository;
//    public ItemController(@Autowired ItemRepository itemRepository )
//    {
//        this.itemRepository = itemRepository;
//    }

    final ItemService itemService;


    public ItemController( @Autowired ItemService itemService )
    {
        this.itemService = itemService;
    }

    /* @GetMapping
    public Iterable<Item> getItems(){

        return itemRepository.findAll();
    }*/



    @CrossOrigin
    @GetMapping( "/all" )
    public Iterable<Item> getItems()
    {
        return itemService.all();
    }

//    @CrossOrigin
//    @GetMapping( "/all" )
//    public CollectionModel<EntityModel<Item>> getItems() {
//        return itemService.all();
//    }

//    @CrossOrigin
//    @GetMapping("/{category}" )
//    public CollectionModel<EntityModel<Item>> getItemsByCategory(@PathVariable String category) {
//        return itemService.getItemsByCategory(category);
//    }

    @CrossOrigin
    @PostMapping
    public Item save( @RequestBody ItemDto itemDto )
    {
        return itemService.save( new Item( itemDto) );
    }

    @GetMapping( "/{id}" )
    public Item findItemById( @PathVariable Integer id )
    {
        return itemService.findItemById( id );
    }
//    @GetMapping( "/{id}" )
//    public EntityModel<Item>  findItemById( @PathVariable Integer id )
//    {
//        return itemService.findById( id );
//    }

//    @GetMapping("/{id}")
//    EntityModel<Item> one(@PathVariable int id) {
//
//        Item item = repository.findById(id) //
//                .orElseThrow(() -> new ItemNotFoundException(id));
//
//        return EntityModel.of(item, //
//                linkTo(methodOn(ItemController.class).one(id)).withSelfRel(),
//                linkTo(methodOn(ItemController.class).getItems()).withRel("items"));
//    }
    @PutMapping( "/{id}" )
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

}