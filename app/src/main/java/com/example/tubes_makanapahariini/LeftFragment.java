package com.example.tubes_makanapahariini;

//THIS IS DRAWER
//CONTAINS
//
//HOME
//SEARCH
//SETTING MENU
//EXIT PROGRAM

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LeftFragment extends Fragment implements View.OnClickListener{

    FragmentListener fragmentListener;
    TextView home, cari, menu, settings, close;

    public LeftFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);

        //COBA KAMU CONVERT KE VIEW BINDING BUAT OPTIMASI TRIMS

        this.home = view.findViewById(R.id.homeButton);
        this.cari = view.findViewById(R.id.cari);
        this.close = view.findViewById(R.id.close);
        this.settings = view.findViewById(R.id.setting);
        this.menu = view.findViewById(R.id.menu);

        this.home.setOnClickListener(this);
        this.cari.setOnClickListener(this);
        this.close.setOnClickListener(this);
        this.settings.setOnClickListener(this);
        this.menu.setOnClickListener(this);

        return view;
    }

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
    public void onClick(View view) {
        if(view == this.home){
            fragmentListener.changePage(1);
        } else if(view == this.settings){
            fragmentListener.changePage(2);
        } else if(view == this.close){
            fragmentListener.closeApplication();
        }
    }
}
