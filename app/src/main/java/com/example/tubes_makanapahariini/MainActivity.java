package com.example.tubes_makanapahariini;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FragmentListener {
    private Toolbar toolbar;
    private MainFragment fragmentMain;
    private FragmentManager fragmentManager;
    private DrawerLayout drawer;
    private ListView listView;
    private TextView foodListItem;
    private FoodListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.toolbar = findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);

        this.drawer = findViewById(R.id.drawer_layout);
        this.fragmentMain = MainFragment.newInstance();
        this.fragmentManager = this.getSupportFragmentManager();
        this.foodListItem = this.findViewById(R.id.food_item_string);
        this.listView = this.findViewById(R.id.list_foods);

        ActionBarDrawerToggle abdt = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawer.addDrawerListener(abdt);
        abdt.syncState();

        /* I'm pretty sure this shouldn't go here... (null pointer)
        this.adapter.add("Menu A");
        this.adapter.add("Menu B");
        this.adapter.add("Menu C");
         */
    }

    @Override
    public void changePage(int page) {
        //Not done yet
        /*
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        if (page == 1) {
            if (this.fragmentMain.isAdded()) {
                this.drawer.closeDrawers();
                ft.show(this.fragmentMain);
            }
            else {
                this.drawer.closeDrawers();
                ft.add(R.id.fragment_container, this.fragmentMain);
            }

            if (this.fragment2.isAdded()) {
                this.drawer.closeDrawers();
                ft.hide(this.fragment2);
            }
        }
        else if (page == 2) {
            if (this.fragment2.isAdded()) {
                this.drawer.closeDrawers();
                ft.show(this.fragment2);
            }
            else {
                this.drawer.closeDrawers();
                ft.add(R.id.fragment_container, this.fragment2).addToBackStack(null);
            }

            if (this.fragmentm.isAdded()) {
                this.drawer.closeDrawers();
                ft.hide(this.fragmentm);
            }
        }
        ft.commit();
         */
    }

    @Override
    public void closeApplication() {
        this.moveTaskToBack(true);
        this.finish();
    }

    @Override
    public void showMessage(String result) {
        //What is this for again?
    }
}