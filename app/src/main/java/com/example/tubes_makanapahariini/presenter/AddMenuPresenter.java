package com.example.tubes_makanapahariini.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.tubes_makanapahariini.DBHandler;
import com.example.tubes_makanapahariini.model.Food;

public class AddMenuPresenter {
    private INewMenu ui;
    private DBHandler db;
    private Toast toast;

    public AddMenuPresenter(DBHandler db, INewMenu ui) {
        this.ui = ui;
        this.db = db;
    }

    public interface INewMenu {
        void clearForm();
    }

    public void AddNew(Food food, Context context) {
        this.db.addRecord(food);
        this.toast = Toast.makeText(context,"Menu telah ditambahkan", Toast.LENGTH_SHORT);
        this.toast.show();

        this.ui.clearForm();
    }
}
