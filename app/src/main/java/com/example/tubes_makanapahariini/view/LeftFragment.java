package com.example.tubes_makanapahariini.view;

//Left drawer

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.tubes_makanapahariini.R;
import com.example.tubes_makanapahariini.view.FragmentListener;

public class LeftFragment extends Fragment implements View.OnClickListener {
    private FragmentListener fragmentListener;
    private TextView home;
    private TextView search;
    private TextView menu;
    private TextView settings;
    private TextView close;

    public LeftFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);

        //COBA KAMU CONVERT KE VIEW BINDING BUAT OPTIMASI TRIMS

        this.home = view.findViewById(R.id.drawer_home);
        this.search = view.findViewById(R.id.drawer_search);
        this.menu = view.findViewById(R.id.drawer_menu);
        this.settings = view.findViewById(R.id.drawer_setting);
        this.close = view.findViewById(R.id.drawer_exit);

        this.home.setOnClickListener(this);
        this.search.setOnClickListener(this);
        this.menu.setOnClickListener(this);
        this.settings.setOnClickListener(this);
        this.close.setOnClickListener(this);

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
    public void onClick(View view) {
        if (view == this.home) {
            fragmentListener.changePage(1);
        }
        else if (view == this.settings) {
            fragmentListener.changePage(2);
        }
        else if (view == this.menu) {
            fragmentListener.changePage(3);
        }
        else if (view == this.settings) {
            fragmentListener.changePage(4);
        }
        else if(view == this.close) {
            fragmentListener.closeApplication();
        }
    }
}
