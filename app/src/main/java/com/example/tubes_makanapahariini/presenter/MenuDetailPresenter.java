package com.example.tubes_makanapahariini.presenter;

import com.example.tubes_makanapahariini.DBHandler;
import com.example.tubes_makanapahariini.model.Food;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuDetailPresenter {
    public Food food;
    public int id;
    public DBHandler dbHandler;
    public IMenuDetailActivity ui;

    public MenuDetailPresenter(int id, IMenuDetailActivity ui, DBHandler dbHandler) {
        //this.food = new Food();
        this.id = id;
        this.dbHandler = dbHandler;
        this.ui = ui;
    }

    public interface IMenuDetailActivity{
        void UpdateData(List<Food> data);
        void writeData(Food item);
    }

    public void addNew(String title, String detail) {
//        Food item = new Food(title, detail);
//        this.foods.add(item);
//        this.ui.UpdateList(this.foods);
//        this.ui.resetAddForm();
    }

    public void loadData() {
        //this.ui.UpdateData(this.foods);
    }

    public void readData() {
        Food item = this.dbHandler.getFood(this.id);
        this.ui.writeData(item);
    }
}
