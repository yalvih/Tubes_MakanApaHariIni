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

import com.example.tubes_makanapahariini.R;
import com.example.tubes_makanapahariini.presenter.MainMenuPresenter;

public class AddNewMenuFragment extends Fragment {
    public TextView menu, detail,ingredients,main_text;
    public EditText add_menu, add_detail, add_ingredients;
    public Button add;
    FragmentListener fragmentListener;

    public AddNewMenuFragment() {}

    public static AddNewMenuFragment newInstance() {
        AddNewMenuFragment fragment = new AddNewMenuFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_menu_fragment, container, false);
        this.main_text = view.findViewById(R.id.main_text);
        this.menu = view.findViewById(R.id.title_add_menu);
        this.detail = view.findViewById(R.id.title_add_description);
        this.ingredients = view.findViewById(R.id.title_add_ingredients);

        this.add_menu = view.findViewById(R.id.add_menu);
        this.add_detail = view.findViewById(R.id.add_description);
        this.add_ingredients = view.findViewById(R.id.add_ingredients);
        this.add = view.findViewById(R.id.add_data);

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
}
