package com.example.tubes_makanapahariini.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.tubes_makanapahariini.DBHandler;
import com.example.tubes_makanapahariini.R;
import com.example.tubes_makanapahariini.model.Food;
import com.example.tubes_makanapahariini.presenter.MainMenuPresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

//MENU LIST PAGE WITH EDIT BUTTON

public class MainMenuFragment extends Fragment implements AdapterView.OnItemClickListener, MainMenuPresenter.IMainMenuActivity, ViewGroup.OnClickListener{
    ListView listView;
    FragmentListener fragmentListener;
    MainMenuPresenter mainMenuPresenter;
    FloatingActionButton fab;
    MainMenuFragmentAdapter frag;
    DBHandler dbHandler;

    public MainMenuFragment() { }

    public static MainMenuFragment newInstance() {
        MainMenuFragment fragment = new MainMenuFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_menu_fragment, container, false);
        this.listView = view.findViewById(R.id.list_foods);
        this.dbHandler = new DBHandler(this.getActivity());
        this.fab = view.findViewById(R.id.fab1);
        this.fab.setOnClickListener(this);
        this.mainMenuPresenter = new MainMenuPresenter(this, this.dbHandler);

        this.frag = new MainMenuFragmentAdapter(this.getActivity());
        this.listView.setAdapter(this.frag);
        this.listView.setOnItemClickListener(this);
//        this.listView.setOnClickListener(this);
        mainMenuPresenter.loadData();
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

    @Override
    public void UpdateList(List<Food> data) {
        frag.updateList(data);
        frag.notifyDataSetChanged();
    }

    @Override
    public void openDetails(int id) {
        this.fragmentListener.changeMenuId(id);
        this.fragmentListener.changePage(6);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        this.mainMenuPresenter.openDetails(i);
    }
}