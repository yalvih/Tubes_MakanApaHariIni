package com.example.tubes_makanapahariini.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tubes_makanapahariini.R;

import static android.content.Context.MODE_PRIVATE;

// Helper class for themes

public class Utils {
    private static int themeCode;
    public final static int THEME_UNSET = 0;
    public final static int THEME_LIGHT = 1;
    public final static int THEME_DARK = 2;

    public Utils(int themeCode) {
        this.themeCode = themeCode;
    }

    public static void changeToTheme(AppCompatActivity activity, int theme) {
        themeCode = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void setThemeOnCreate(AppCompatActivity activity) {
        if (themeCode == THEME_UNSET) {
            activity.setTheme(R.style.AppTheme);
        }
        else if (themeCode == THEME_LIGHT) {
            activity.setTheme(R.style.AppTheme);
        }
        else if (themeCode == THEME_DARK) {
            activity.setTheme(R.style.AppThemeDark);
        }
        else {
            Log.d("Debug", "Theme Error!");
            activity.setTheme(R.style.AppTheme);
        }
    }
}
