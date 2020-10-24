package com.example.tubes_makanapahariini.model;

import java.lang.reflect.Array;

public class Food {
    private String title;
    private String description;
    private String locate_restaurant;
    private String name_restaurant;
    private String ingredients;
    public int id;

    public Food(int id, String title, String description, String ingredients, String locate_restaurant, String name_restaurant) {
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        this.locate_restaurant = locate_restaurant;
        this.name_restaurant = name_restaurant;
        this.id = id;
    }

    public Food(){}

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocate_restaurant() {
        return locate_restaurant;
    }

    public String getName_restaurant() {
        return name_restaurant;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocate_restaurant(String locate_restaurant) {
        this.locate_restaurant = locate_restaurant;
    }

    public void setName_restaurant(String name_restaurant) {
        this.name_restaurant = name_restaurant;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
