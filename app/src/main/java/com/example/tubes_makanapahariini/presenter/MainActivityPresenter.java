package com.example.tubes_makanapahariini.presenter;

import com.example.tubes_makanapahariini.DBHandler;
import com.example.tubes_makanapahariini.SettingsPrefSaver;
import com.example.tubes_makanapahariini.model.Food;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivityPresenter {
    private SettingsPrefSaver settingsPrefSaver;
    DBHandler dbHandler;

    public MainActivityPresenter(DBHandler dbHandler) {
        this.settingsPrefSaver = settingsPrefSaver;
        this.dbHandler = dbHandler;
    }

    public void loadSettings(){
        //DARK MODE HERE
    }

    public int openRandom(){

        int max = this.dbHandler.getAllRecord().size()-1;
        int randomNum = ThreadLocalRandom.current().nextInt(0, max + 1);
        List<Food> foods = dbHandler.getAllRecord();
        return foods.get(randomNum).getId();
    }



}
