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

        //Debug
        for (int i = 0; i < this.foods.size(); i++) {
            Log.d("Load_FoodID", Integer.toString(foods.get(i).getId()));
            Log.d("Load_FoodTitle", foods.get(i).getTitle());
            Log.d("Load_FoodDesc", foods.get(i).getDescription());
            Log.d("Load_FoodIngr", foods.get(i).getIngredients());
            Log.d("Load_FoodRest", foods.get(i).getLocate_restaurant());
        }

        this.ui.UpdateList(this.foods);
    }
}
