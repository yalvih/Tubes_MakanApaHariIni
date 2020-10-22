package com.example.tubes_makanapahariini.presenter;

import com.example.tubes_makanapahariini.model.Food;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainPresenter {
    protected List<Food> foods;
    protected IMainActivity ui;

    public MainPresenter(IMainActivity ui) {
        this.foods = new ArrayList<>();
        this.ui = ui;
    }

    interface IMainActivity {
        void UpdateList(List<Food> data);
    }

    public void addNew(String title, String detail) {
//        Food item = new Food(title, detail);
//        this.foods.add(item);
//        this.ui.UpdateList(this.foods);
//        this.ui.resetAddForm();
    }

    public void loadData() {
        this.foods.addAll(Arrays.asList(MockFood.foodObjectArr));
        this.ui.UpdateList(this.foods);
    }






}
