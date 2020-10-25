package com.example.tubes_makanapahariini.presenter;

import com.example.tubes_makanapahariini.DBHandler;
import com.example.tubes_makanapahariini.model.Food;

import java.util.ArrayList;
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

    public interface ISearchPresenter {
        void UpdateList(List<Food> data);
        void openDetails(int id);
    }

    public void openDetails(int i) {
        int id = this.foods.get(i).getId();
        this.ui.openDetails(id);
    }

    public void loadData(String query) {
        this.foods = dbHandler.getSearchResults(query);
        this.ui.UpdateList(this.foods);
    }
}
