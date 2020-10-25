package com.example.tubes_makanapahariini.view;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;

import com.example.tubes_makanapahariini.R;
import com.example.tubes_makanapahariini.databinding.ActivityMainBinding;
import com.example.tubes_makanapahariini.presenter.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements FragmentListener {
    SharedPreferences sp;
    SharedPreferences.Editor spEditor;
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private ActivityMainBinding bind;
    private FragmentManager fragmentManager;
    private MainFragment mainFragment;
    private SearchFragment searchFragment;
    private MainMenuFragment mainMenu;
    private AddNewMenuFragment addNewMenuFragment;
    private MenuDetailsFragment menuDetailsFragment;
    private SettingsFragment settingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = this.getPreferences(MODE_PRIVATE);
        spEditor = sp.edit();

        new Utils(this.sp.getInt("DARK_THEME", 0));
        Utils.setThemeOnCreate(this);

        this.bind = ActivityMainBinding.inflate(getLayoutInflater());
        View view = this.bind.getRoot();
        setContentView(view);
        this.setSupportActionBar(this.bind.toolbar);

        this.toolbar = findViewById(R.id.toolbar);
        this.drawer = findViewById(R.id.drawer_layout);

        this.mainFragment = MainFragment.newInstance();
        this.searchFragment = SearchFragment.newInstance();
        this.mainMenu = MainMenuFragment.newInstance();
        this.menuDetailsFragment = MenuDetailsFragment.newInstance(0);
        this.addNewMenuFragment = AddNewMenuFragment.newInstance();
        this.settingsFragment = SettingsFragment.newInstance();
        this.fragmentManager = this.getSupportFragmentManager();

        ActionBarDrawerToggle abdt = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawer.addDrawerListener(abdt);
        abdt.syncState();

        changePage(1);
    }

    @Override
    public void changeTheme(int theme) {
        if (theme == 1) {
            Utils.changeToTheme(this, Utils.THEME_LIGHT);
        }
        else if (theme == 2) {
            Utils.changeToTheme(this, Utils.THEME_DARK);
        }
        else {
            Utils.changeToTheme(this, Utils.THEME_UNSET);
        }
    }

    @Override
    public void changePage(int page) {
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        if (page == 1) {
            ft.replace(R.id.fragment_container, this.mainFragment).addToBackStack(null);
        }
        else if (page == 2) {
            ft.replace(R.id.fragment_container, this.searchFragment).addToBackStack(null);
        }
        else if (page == 3) {
            ft.replace(R.id.fragment_container, this.mainMenu).addToBackStack(null);
        }
        else if (page == 4) {
            ft.replace(R.id.fragment_container, this.settingsFragment).addToBackStack(null);
        }
        else if (page == 5) {
            ft.replace(R.id.fragment_container, this.addNewMenuFragment).addToBackStack(null);
        }
        else if (page == 6) {
            ft.replace(R.id.fragment_container, this.menuDetailsFragment).addToBackStack(null);
        }
        ft.commit();

        this.bind.drawerLayout.closeDrawers();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(this.bind.drawerLayout.getWindowToken(), 0);
    }

    @Override
    public void closeApplication() {
        this.moveTaskToBack(true);
        this.finish();
        this.bind.drawerLayout.closeDrawers();
    }

    @Override
    public void changeMenuId(int id) {
        this.menuDetailsFragment = MenuDetailsFragment.newInstance(id);
    }
}