package com.example.tubes_makanapahariini.model;

import java.lang.reflect.Array;

public class Food {
    public String getLocate_restaurant;
    private String title;
    private String description;
    private String ingredients;
    private String restaurantName;
    private String restaurantLocation;
    public int id;

    public Food(int id, String title, String description, String ingredients, String restaurantLocation, String restaurantName) {
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        this.restaurantName = restaurantName;
        this.restaurantLocation = restaurantLocation;
        this.id = id;
    }

    public Food() { }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getName_restaurant() {
        return restaurantName;
    }

    public String getRestaurant_location() {
        return restaurantLocation;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setRestaurant_name(String name_restaurant) {
        this.restaurantName = name_restaurant;
    }

    public void setRestaurant_location(String locate_restaurant) {
        this.restaurantLocation = locate_restaurant;
    }
}
