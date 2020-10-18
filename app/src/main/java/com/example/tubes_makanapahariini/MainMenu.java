package com.example.tubes_makanapahariini;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

public class MainMenu extends Fragment implements ViewGroup.OnClickListener{
    ListView listView;
    FragmentListener fragmentListener;

    public MainMenu() {}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        this.listView = view.findViewById(R.id.list_foods);
        return view;
    }

    public static MainMenu newInstance(){
        MainMenu fragment = new MainMenu();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    //LATER USED FOR BUTTON
//    @Override
//    public void onClick(View v) {
////        if(v == this.cari){
////            this.fragmentListener.changePage(2);
////        }
//    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.fragmentListener = (FragmentListener) context;
        } else{
            throw new ClassCastException(context.toString() + " must implement FragmentListener");
        }
    }

    @Override
    public void onClick(View v) {

    }
}