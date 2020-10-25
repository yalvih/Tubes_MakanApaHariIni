package com.example.tubes_makanapahariini.view;

// Main page

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.tubes_makanapahariini.DBHandler;
import com.example.tubes_makanapahariini.R;
import com.example.tubes_makanapahariini.presenter.MainActivityPresenter;

public class MainFragment extends Fragment implements ViewGroup.OnClickListener {
    DBHandler dbHandler;
    FragmentListener fragmentListener;
    MainActivityPresenter mainActivityPresenter;
    TextView caption;
    Button randomize;
    Toast toast;

    public MainFragment() { }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        this.dbHandler = new DBHandler(this.getActivity());
        this.mainActivityPresenter = new MainActivityPresenter(dbHandler);

        this.caption = view.findViewById(R.id.main_text);
        this.randomize = view.findViewById(R.id.main_search);
        this.randomize.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == this.randomize) {
            // Check whether database is empty - function won't run if it is
            boolean isEmpty = this.mainActivityPresenter.checkDBSize() == 0;
            if (isEmpty == false) {
                this.fragmentListener.changeMenuId(this.mainActivityPresenter.openRandom());
                this.fragmentListener.changePage(6);
            }
            else {
                this.toast = Toast.makeText(this.getActivity(),"Tidak ada menu yang terdaftar!",Toast.LENGTH_SHORT);
                this.toast.show();
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentListener) {
            this.fragmentListener = (FragmentListener) context;
        }
        else {
            throw new ClassCastException(context.toString() + " must implement FragmentListener!");
        }
    }
}
