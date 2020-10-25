package com.example.tubes_makanapahariini.view;

//Left drawer

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.tubes_makanapahariini.R;
import com.example.tubes_makanapahariini.view.FragmentListener;

public class LeftFragment extends Fragment implements View.OnClickListener {
    private FragmentListener fragmentListener;
    private TextView home, search, menu, settings, close;
    private ImageView iconHome, iconSearch, iconMenu, iconSettings, iconClose;

    public LeftFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);

        this.home = view.findViewById(R.id.drawer_home);
        this.search = view.findViewById(R.id.drawer_search);
        this.menu = view.findViewById(R.id.drawer_menu);
        this.settings = view.findViewById(R.id.drawer_setting);
        this.close = view.findViewById(R.id.drawer_exit);
        this.iconHome = view.findViewById(R.id.drawer_icon_home);
        this.iconSearch = view.findViewById(R.id.drawer_icon_search);
        this.iconMenu = view.findViewById(R.id.drawer_icon_menu);
        this.iconSettings = view.findViewById(R.id.drawer_icon_setting);
        this.iconClose = view.findViewById(R.id.drawer_icon_exit);

        this.home.setOnClickListener(this);
        this.search.setOnClickListener(this);
        this.menu.setOnClickListener(this);
        this.settings.setOnClickListener(this);
        this.close.setOnClickListener(this);
        this.iconHome.setOnClickListener(this);
        this.iconSearch.setOnClickListener(this);
        this.iconMenu.setOnClickListener(this);
        this.iconSettings.setOnClickListener(this);
        this.iconClose.setOnClickListener(this);

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
        if (view == this.iconHome || view == this.home) {
            fragmentListener.changePage(1);
        }
        else if (view == this.iconSearch || view == this.search) {
            fragmentListener.changePage(2);
        }
        else if (view == this.iconMenu || view == this.menu) {
            fragmentListener.changePage(3);
        }
        else if (view == this.iconSettings || view == this.settings) {
            fragmentListener.changePage(4);
        }
        else if(view == this.iconClose || view == this.close) {
            fragmentListener.closeApplication();
        }
    }
}
