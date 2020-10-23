package com.example.tubes_makanapahariini.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.tubes_makanapahariini.R;
import com.example.tubes_makanapahariini.model.Food;
import com.example.tubes_makanapahariini.presenter.MenuDetailPresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MenuDetailsFragment extends Fragment implements ViewGroup.OnClickListener {
    FragmentListener fragmentListener;
    MenuDetailPresenter menuDetailPresenter;
    FloatingActionButton fab;
    //MainMenuFragmentAdapter frag;
    TextView tvTitle;
    TextView tvDescription;
    TextView tvIngredients;

    public MenuDetailsFragment() { }

    public static MenuDetailsFragment newInstance() {
        MenuDetailsFragment fragment = new MenuDetailsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_detail_fragment, container, false);
        //this.fab = view.findViewById(R.id.fab1);
        //this.fab.setOnClickListener(this);
        //this.menuDetailPresenter = new MainMenuPresenter(this);

        //this.frag = new MainMenuFragmentAdapter(this.getActivity());
        //this.listView.setAdapter(this.frag);
        //this.listView.setOnClickListener(this);

        this.tvTitle = view.findViewById(R.id.details_title);
        this.tvDescription = view.findViewById(R.id.details_description);
        this.tvIngredients = view.findViewById(R.id.details_ingredients);

        this.tvTitle.setText("Menu Title");
        this.tvDescription.setText("Description");
        this.tvIngredients.setText("- Ingredient 1\n- Ingredient2\n- Ingredient 3\n- Ingredient 4");
        //menuDetailPresenter.loadData();
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

    //LATER USED FOR BUTTON
    @Override
    public void onClick(View v) {
        if(v == this.fab){
            this.fragmentListener.changePage(5);
        }
    }
}

