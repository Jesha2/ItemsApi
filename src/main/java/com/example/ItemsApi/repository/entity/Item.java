package com.example.ItemsApi.repository.entity;

import com.example.ItemsApi.controller.ItemDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

    @Entity
    public class Item
    {
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Integer id;
        private String category;
        private String name;
        private String description;
        private String imageUrl;
        private double price;
        private String size;
        private int quantity;

        public Item(ItemDto itemDto) {
            this.category = itemDto.getCategory();
            this.name = itemDto.getName();
            this.description = itemDto.getDescription();
            this.imageUrl = itemDto.getImageUrl();
            this.quantity  =itemDto.getQuantity();
            this.price = itemDto.getPrice();
            this.size = itemDto.getSize();


        }

        public Item() {
        }

        public Integer getId()
        {
            return id;
        }

        public void setId( Integer id )
        {
            this.id = id;
        }

        public String getName()
        {
            return name;
        }

        public void setName( String name )
        {
            this.name = name;
        }

        public String getDescription()
        {
            return description;
        }

        public void setDescription( String description )
        {
            this.description = description;
        }

        public String getImageUrl()
        {
            return imageUrl;
        }

        public void setImageUrl( String imageUrl )
        {
            this.imageUrl = imageUrl;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "id=" + id +
                    ", category='" + category + '\'' +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", imageUrl='" + imageUrl + '\'' +
                    ", price=" + price +
                    ", size='" + size + '\'' +
                    ", quantity=" + quantity +
                    '}';
        }
    }

