package com.example.tubes_makanapahariini.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.tubes_makanapahariini.DBHandler;
import com.example.tubes_makanapahariini.R;
import com.example.tubes_makanapahariini.model.Food;
import com.example.tubes_makanapahariini.presenter.MainMenuPresenter;
import com.example.tubes_makanapahariini.presenter.MenuDetailPresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MenuDetailsFragment extends Fragment implements View.OnClickListener, MenuDetailPresenter.IMenuDetailActivity{
    FragmentListener fragmentListener;
    MenuDetailPresenter menuDetailPresenter;
    FloatingActionButton fab_save, fab_edit, fab_delete;
    DBHandler dbHandler;
    Toast toast;
    int id;
    EditText tvTitle,tvDescription, tvIngredients, tvNameRestaurant, tvLocateRestaurant;

    public MenuDetailsFragment() { }

    public static MenuDetailsFragment newInstance(int id) {
        MenuDetailsFragment fragment = new MenuDetailsFragment();
        Bundle args = new Bundle();
        args.putInt("id", id);
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_detail_fragment, container, false);
        this.dbHandler = new DBHandler(this.getActivity());

        this.id = this.getArguments().getInt("id",0);
        this.tvTitle = view.findViewById(R.id.details_title);
        this.tvDescription = view.findViewById(R.id.details_description);
        this.tvIngredients = view.findViewById(R.id.details_ingredients);
        this.tvNameRestaurant = view.findViewById(R.id.details_name_restaurant);
        this.tvLocateRestaurant = view.findViewById(R.id.details_location_restaurant);
        this.fab_delete = view.findViewById(R.id.fab_delete);
        this.fab_edit = view.findViewById(R.id.fab_edit);
        this.fab_save = view.findViewById(R.id.fab_save);

        this.fab_delete.setOnClickListener(this);
        this.fab_edit.setOnClickListener(this);
        this.fab_save.setOnClickListener(this);

        this.menuDetailPresenter = new MenuDetailPresenter(id, this, this.dbHandler);
        this.menuDetailPresenter.readData();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentListener) {
            this.fragmentListener = (FragmentListener) context;
        }
        else {
            throw new ClassCastException(context.toString() + " must implement FragmentListener");
        }
    }

    @Override
    public void onClick(View v) {
        if(v == this.fab_edit){
            this.tvTitle.setFocusableInTouchMode(true);
            this.tvDescription.setFocusableInTouchMode(true);
            this.tvIngredients.setFocusableInTouchMode(true);
            this.tvNameRestaurant.setFocusableInTouchMode(true);
            this.tvLocateRestaurant.setFocusableInTouchMode(true);
            this.toast = Toast.makeText(this.getActivity(),"You Can Edit Now",Toast.LENGTH_SHORT);
            this.toast.show();
        }
        if(v == this.fab_save){
            Food food = new Food();
            food.setId(this.id);
            food.setTitle(tvTitle.getText().toString());
            food.setDescription(tvDescription.getText().toString());
            food.setIngredients(tvIngredients.getText().toString());
            food.setName_restaurant(tvNameRestaurant.getText().toString());
            food.setLocate_restaurant(tvLocateRestaurant.getText().toString());
            this.menuDetailPresenter.saveData(food);
            this.fragmentListener.changePage(3);

            this.toast = Toast.makeText(this.getActivity(),"Data has been updated",Toast.LENGTH_SHORT);
            this.toast.show();
        }
        if(v == this.fab_delete){
            Food food = new Food();
            food.setId(this.id);
            food.setTitle(tvTitle.getText().toString());
            food.setDescription(tvDescription.getText().toString());
            food.setIngredients(tvIngredients.getText().toString());
            food.setName_restaurant(tvNameRestaurant.getText().toString());
            food.setLocate_restaurant(tvLocateRestaurant.getText().toString());
            this.menuDetailPresenter.deleteData(food);
            this.fragmentListener.changePage(3);

            this.toast = Toast.makeText(this.getActivity(),"Data has been deleted",Toast.LENGTH_SHORT);
            this.toast.show();
        }
    }

    @Override
    public void UpdateData(List<Food> data) {

    }

    @Override
    public void writeData(Food item) {
        this.tvTitle.setText(item.getTitle());
        this.tvDescription.setText(item.getDescription());
        this.tvIngredients.setText(item.getIngredients());
        this.tvNameRestaurant.setText(item.getName_restaurant());
        this.tvLocateRestaurant.setText(item.getLocate_restaurant());
    }
}

