package com.example.tubes_makanapahariini.view;

//MAIN PAGE FRAGMENT

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ThreadLocalRandom;

import androidx.fragment.app.Fragment;

import com.example.tubes_makanapahariini.DBHandler;
import com.example.tubes_makanapahariini.R;
import com.example.tubes_makanapahariini.presenter.MainActivityPresenter;
import com.example.tubes_makanapahariini.presenter.MenuDetailPresenter;

public class MainFragment extends Fragment implements ViewGroup.OnClickListener {
    TextView caption;
    Button search;
    DBHandler dbHandler;
    FragmentListener fragmentListener;
    MainActivityPresenter mainActivityPresenter;
    Toast toast;

    public MainFragment() { }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        this.caption = view.findViewById(R.id.main_text);
        this.search = view.findViewById(R.id.main_search);
        this.dbHandler = new DBHandler(this.getActivity());
        this.search.setOnClickListener(this);

        this.mainActivityPresenter = new MainActivityPresenter(dbHandler);
        return view;
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onClick(View v) {
        if (v == this.search) {
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
            throw new ClassCastException(context.toString() + " must implement FragmentListener");
        }
    }
}
