package com.example.ItemsApi.controller;

public class ItemDto {

    private String category;
    private String name;
    private String description;
    private String imageUrl;
    private double price;
    private String size;
    private int quantity;

    public ItemDto( String category, String name, String description, String imageUrl,double price,
                        String size, int quantity)
        {
            this.category = category;
            this.name = name;
            this.description = description;
            this.imageUrl = imageUrl;
            this.price =price;
            this.size = size;
            this.quantity = quantity;

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
}