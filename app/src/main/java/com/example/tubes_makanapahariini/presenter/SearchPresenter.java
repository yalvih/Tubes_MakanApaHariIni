package com.example.tubes_makanapahariini.presenter;

import com.example.tubes_makanapahariini.model.Food;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchPresenter {
    public List<Food> foods;
    public ISearchPresenter ui;

    public SearchPresenter(ISearchPresenter ui) {
        this.foods = new ArrayList<>();
        this.ui = ui;
    }

    public interface ISearchPresenter{
        void UpdateList(List<Food> data);
    }

    public void loadData(){
        this.foods.addAll(Arrays.asList(MockFood.foodObjectArr));
        this.ui.UpdateList(this.foods);
    }
}
