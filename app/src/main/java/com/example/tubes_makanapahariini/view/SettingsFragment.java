package com.example.tubes_makanapahariini.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.tubes_makanapahariini.DBHandler;
import com.example.tubes_makanapahariini.R;
import static android.content.Context.MODE_PRIVATE;

// Settings

public class SettingsFragment extends Fragment implements ViewGroup.OnClickListener {
    DBHandler dbHandler;
    FragmentListener fragmentListener;
    SharedPreferences sp;
    SharedPreferences.Editor spEditor;
    int darkTheme;
    Button btnDarkTheme;
    Button btnDeleteAll;
    Toast toast;

    public SettingsFragment() { }

    public static SettingsFragment newInstance() {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_fragment, container, false);
        this.dbHandler = new DBHandler(this.getActivity());
        sp = this.getActivity().getPreferences(MODE_PRIVATE);
        spEditor = sp.edit();

        this.btnDarkTheme = view.findViewById(R.id.settings_button_theme);
        this.btnDeleteAll = view.findViewById(R.id.settings_button_delete_all);

        this.darkTheme = this.sp.getInt("DARK_THEME", 0);
        if (this.darkTheme == 2) {
            this.btnDarkTheme.setText("DISABLE");
        }
        else this.btnDarkTheme.setText("ENABLE");

        this.btnDarkTheme.setOnClickListener(this);
        this.btnDeleteAll.setOnClickListener(this);

        return view;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentListener) {
            this.fragmentListener = (FragmentListener) context;
        }
        else {
            throw new ClassCastException(context.toString() + " must implement FragmentListener!");
        }
    }

    @Override
    public void onClick(View v) {
        sp = this.getActivity().getPreferences(MODE_PRIVATE);
        spEditor = sp.edit();

        if (v == this.btnDarkTheme) {
            if (this.darkTheme == 2) {
                this.spEditor.putInt("DARK_THEME", 1);
                spEditor.apply();
                fragmentListener.changeTheme(1);
            }
            else {
                this.spEditor.putInt("DARK_THEME", 2);
                spEditor.apply();
                fragmentListener.changeTheme(2);
            }
        }
        else if (v == this.btnDeleteAll) {
            this.toast = Toast.makeText(this.getActivity(),"Semua menu yang terdaftar telah dihapus.", Toast.LENGTH_SHORT);
            toast.show();
            this.dbHandler.deleteAllFood();
        }
    }
}
