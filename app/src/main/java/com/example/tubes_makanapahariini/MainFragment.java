package com.example.tubes_makanapahariini;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

//INI BAGIAN DEPAN YANG ADA BUTTON CARI YA
public class MainFragment extends Fragment implements ViewGroup.OnClickListener {
    TextView txt;
    Button cari;
    FragmentListener fragmentListener;

    public MainFragment() {}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        this.txt = view.findViewById(R.id.txt);//JUST TEXT
        this.cari = view.findViewById(R.id.cari);//DRAWER DAN YANG MAIN PAGE PUNYA ADDRESS YANG SAMA !
        this.cari.setOnClickListener(this);
        return view;
    }

    public static MainFragment newInstance(){
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onClick(View v) {
//        if(v == this.cari){
//            this.fragmentListener.changePage(2);
//        }
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
}
