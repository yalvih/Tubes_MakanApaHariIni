package com.example.tubes_makanapahariini.view;

//SETTINGS FRAGMENT

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.tubes_makanapahariini.R;
import com.example.tubes_makanapahariini.databinding.ActivityMainBinding;

public class SettingsFragment extends Fragment implements ViewGroup.OnClickListener {
    TextView labelDarkTheme;
    Button btnDarkTheme;
    ActivityMainBinding bind;
    FragmentListener fragmentListener;

    public SettingsFragment() { }

    public static SettingsFragment newInstance() {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_fragment, container, false);
        this.labelDarkTheme = view.findViewById(R.id.settings_text_theme);
        this.btnDarkTheme = view.findViewById(R.id.settings_button_theme);
        return view;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentListener) {
            this.fragmentListener = (FragmentListener) context;
        }
        else {
            throw new ClassCastException(context.toString() + " must implement FragmentListener");
        }
    }

    @Override
    public void onClick(View v) {

    }
}
