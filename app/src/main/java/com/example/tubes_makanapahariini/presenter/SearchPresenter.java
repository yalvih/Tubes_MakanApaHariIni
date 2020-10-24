package com.example.tubes_makanapahariini.presenter;

import com.example.tubes_makanapahariini.DBHandler;
import com.example.tubes_makanapahariini.model.Food;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchPresenter {
    public List<Food> foods;
    public ISearchPresenter ui;
    public DBHandler dbHandler;

    public SearchPresenter(ISearchPresenter ui, DBHandler dbHandler) {
        this.foods = new ArrayList<>();
        this.ui = ui;
        this.dbHandler = dbHandler;
    }

    public interface ISearchPresenter{
        void UpdateList(List<Food> data);
    }

    public void loadData(){
        this.foods = dbHandler.getAllRecord();
        this.ui.UpdateList(this.foods);
    }
}
