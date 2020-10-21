package com.example.tubes_makanapahariini.model;

import java.lang.reflect.Array;

public class Food {
    public String title;
    public String description;
    public String ingredients;
    public int id;

    public Food(String title, String description, String ingredients, int id) {
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getIngredients() {
        return ingredients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
