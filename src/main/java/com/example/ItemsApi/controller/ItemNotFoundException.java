package com.example.ItemsApi.controller;

public class ItemNotFoundException extends RuntimeException {

    public  ItemNotFoundException(int id) {
        super("Could not find item " + id);
    }
}
