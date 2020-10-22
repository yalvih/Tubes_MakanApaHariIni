package com.example.tubes_makanapahariini.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.tubes_makanapahariini.R;
import com.example.tubes_makanapahariini.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements FragmentListener {
    private Toolbar toolbar;
    private MainFragment mainFragment;
    private FragmentManager fragmentManager;
    private DrawerLayout drawer;
    private ListView listView;
    private TextView foodListItem;
    private FoodListAdapter adapter;
    private ActivityMainBinding bind;
    private MainMenu mainMenu;
    private SettingsFragment settingsFragment;
    private SearchFragment searchFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppThemeDark);
        this.bind = ActivityMainBinding.inflate(getLayoutInflater());
        View view = this.bind.getRoot();
        setContentView(view);
        this.setSupportActionBar(this.bind.toolbar);

        //SOON TERMINATED DO NOT DELETE
        this.toolbar = findViewById(R.id.toolbar);
        this.drawer = findViewById(R.id.drawer_layout);
        this.foodListItem = this.findViewById(R.id.food_item_string);
        this.listView = this.findViewById(R.id.list_foods);
        //ENDS HERE

        this.mainFragment = MainFragment.newInstance();
        this.mainMenu = MainMenu.newInstance();
        this.settingsFragment = SettingsFragment.newInstance();
        this.searchFragment = SearchFragment.newInstance();
        this.fragmentManager = this.getSupportFragmentManager();

        ActionBarDrawerToggle abdt = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawer.addDrawerListener(abdt);
        abdt.syncState();
        changePage(1);
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
        ft.commit();
        this.bind.drawerLayout.closeDrawers();
    }

    @Override
    public void closeApplication() {
        this.moveTaskToBack(true);
        this.finish();
        this.bind.drawerLayout.closeDrawers();
    }

    @Override
    public void showMessage(String result) {
        //What is this for again?
    }
}