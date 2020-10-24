package com.example.tubes_makanapahariini.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.tubes_makanapahariini.DBHandler;
import com.example.tubes_makanapahariini.R;
import com.example.tubes_makanapahariini.model.Food;
import com.example.tubes_makanapahariini.presenter.AddMenuPresenter;
import com.example.tubes_makanapahariini.presenter.MainMenuPresenter;

public class AddNewMenuFragment extends Fragment implements View.OnClickListener, AddMenuPresenter.INewMenu {
    public EditText add_menu, add_detail, add_ingredients, add_locate_restaurant, add_name_restaurant;
    public Button add;
    public DBHandler dbHandler;
    FragmentListener fragmentListener;
    public AddMenuPresenter addMenuPresenter;

    public AddNewMenuFragment() {}

    public static AddNewMenuFragment newInstance() {
        AddNewMenuFragment fragment = new AddNewMenuFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_menu_fragment, container, false);
        this.add_menu = view.findViewById(R.id.add_menu);
        this.add_detail = view.findViewById(R.id.add_description);
        this.add_ingredients = view.findViewById(R.id.add_ingredients);
        this.add_locate_restaurant = view.findViewById(R.id.add_locate_restaurant);
        this.add_name_restaurant = view.findViewById(R.id.add_name_restaurant);

        this.dbHandler = new DBHandler(this.getActivity());
        this.addMenuPresenter = new AddMenuPresenter(this.dbHandler, this);

        this.add = view.findViewById(R.id.add_data);
        this.add.setOnClickListener(this);

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
        Food food = new Food(0,
                add_menu.getText().toString(),
                add_detail.getText().toString(),
                add_ingredients.getText().toString(),
                add_locate_restaurant.getText().toString(),
                add_name_restaurant.getText().toString());
        this.addMenuPresenter.AddNew(food,this.getActivity());
    }

    @Override
    public void changePage() {

    }

    @Override
    public void clearForm() {
        this.add_menu.setText("");
        this.add_detail.setText("");
        this.add_ingredients.setText("");
        this.add_locate_restaurant.setText("");
        this.add_name_restaurant.setText("");
    }
}
