package com.example.tubes_makanapahariini;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.tubes_makanapahariini.databinding.ActivityMainBinding;

public class SettingsFragment extends Fragment implements ViewGroup.OnClickListener{

    TextView labelDark;
    Button btn_dark;
    ActivityMainBinding bind;
    FragmentListener fragmentListener;

    public SettingsFragment() { }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        this.labelDark = view.findViewById(R.id.txt);
        this.btn_dark = view.findViewById(R.id.dark_btn);
        return view;
    }

    public static SettingsFragment newInstance(){
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onClick(View v) {

    }

    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.fragmentListener = (FragmentListener) context;
        } else{
            throw new ClassCastException(context.toString() + " must implement FragmentListener");
        }
    }
}
