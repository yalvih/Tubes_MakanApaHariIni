package com.example.tubes_makanapahariini.model;

import java.lang.reflect.Array;

public class Food {
    public String title;
    public String description;
    public String bahan;
    public int id;

    public Food(String title, String description, String bahan, int id) {
        this.title = title;
        this.description = description;
        this.bahan = bahan;
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

    public String getBahan() {
        return bahan;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
