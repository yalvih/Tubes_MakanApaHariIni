package com.example.tubes_makanapahariini.presenter;

import android.util.Log;

import com.example.tubes_makanapahariini.DBHandler;
import com.example.tubes_makanapahariini.model.Food;

import java.util.ArrayList;
import java.util.Arrays;
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

    public void openDetails(int i) {
        int id = this.foods.get(i).getId();
        this.ui.openDetails(id);
    }

    public interface IMainMenuActivity{
        void UpdateList(List<Food> data);
        void openAdd();
        void openDetails(int id);
    }

    public void addNew(String title, String detail) {
//        Food item = new Food(title, detail);
//        this.foods.add(item);
//        this.ui.UpdateList(this.foods);
//        this.ui.resetAddForm();
    }

    public void loadData(){
        this.foods = dbHandler.getAllRecord();

        String str = "";
        for (int i = 0; i < this.foods.size(); i++) {
            str += this.foods.get(i).getId();
        }
        Log.d("debug", str);

        this.ui.UpdateList(this.foods);
    }
}
