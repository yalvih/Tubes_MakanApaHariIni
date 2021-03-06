package com.example.tubes_makanapahariini.presenter;

import com.example.tubes_makanapahariini.DBHandler;
import com.example.tubes_makanapahariini.model.Food;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivityPresenter {
    DBHandler dbHandler;

    public MainActivityPresenter(DBHandler dbHandler) {
        this.dbHandler = dbHandler;
    }

    public int openRandom() {
        int max = this.dbHandler.getAllRecord().size();
        int randomNum = ThreadLocalRandom.current().nextInt(0, max);
        List<Food> foods = dbHandler.getAllRecord();
        return foods.get(randomNum).getId();
    }

    public int checkDBSize() {
        return this.dbHandler.getFoodCount();
    }
}
