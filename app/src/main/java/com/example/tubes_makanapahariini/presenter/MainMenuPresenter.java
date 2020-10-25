package com.example.tubes_makanapahariini.presenter;

import android.util.Log;

import com.example.tubes_makanapahariini.DBHandler;
import com.example.tubes_makanapahariini.model.Food;

import java.util.ArrayList;
import java.util.List;

public class MainMenuPresenter {
    public List<Food> foods;
    public IMainMenuActivity ui;
    public DBHandler dbHandler;

    public MainMenuPresenter(IMainMenuActivity ui, DBHandler dbHandler) {
        this.foods = new ArrayList<>();
        this.ui = ui;
        this.dbHandler = dbHandler;
    }

    public interface IMainMenuActivity {
        void UpdateList(List<Food> data);
        void openDetails(int id);
    }

    public void openDetails(int i) {
        int id = this.foods.get(i).getId();
        this.ui.openDetails(id);
    }

    public void loadData() {
        this.foods = dbHandler.getAllRecord();
        this.ui.UpdateList(this.foods);
    }
}
