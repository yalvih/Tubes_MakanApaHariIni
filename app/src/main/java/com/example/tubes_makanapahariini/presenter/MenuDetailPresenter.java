package com.example.tubes_makanapahariini.presenter;

import com.example.tubes_makanapahariini.model.Food;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuDetailPresenter {
    public Food food;
    public MainMenuPresenter.IMainMenuActivity ui;

    public MenuDetailPresenter(MainMenuPresenter.IMainMenuActivity ui) {
        //this.food = new Food();
        this.ui = ui;
    }

    public interface IMainMenuActivity{
        void UpdateData(List<Food> data);
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
}
