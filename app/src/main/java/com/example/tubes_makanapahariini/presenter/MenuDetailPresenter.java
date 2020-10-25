package com.example.tubes_makanapahariini.presenter;

import com.example.tubes_makanapahariini.DBHandler;
import com.example.tubes_makanapahariini.model.Food;

public class MenuDetailPresenter {
    public Food food;
    public int id;
    public DBHandler dbHandler;
    public IMenuDetailActivity ui;

    public MenuDetailPresenter(int id, IMenuDetailActivity ui, DBHandler dbHandler) {
        this.id = id;
        this.dbHandler = dbHandler;
        this.ui = ui;
    }

    public interface IMenuDetailActivity {
        void writeData(Food item);
    }

    public void readData() {
        Food item = this.dbHandler.getFood(this.id);
        this.ui.writeData(item);
    }

    public void saveData(Food food){
        this.dbHandler.updateFood(food);
    }

    public void deleteData(Food food){
        this.dbHandler.deleteModel(food);
    }
}
