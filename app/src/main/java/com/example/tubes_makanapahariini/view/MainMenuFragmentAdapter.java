package com.example.tubes_makanapahariini.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tubes_makanapahariini.R;
import com.example.tubes_makanapahariini.model.Food;

import java.util.ArrayList;
import java.util.List;

public class MainMenuFragmentAdapter extends BaseAdapter {
    private List<Food> listItem;
    private Context fragment;

    public MainMenuFragmentAdapter(Context fragment) {
        this.fragment = fragment;
        this.listItem = new ArrayList<>();
    }

    public void updateList(List<Food> newList) {
        this.listItem = newList;
    }

    @Override
    public int getCount(){
        return listItem.size();
    }

    @Override
    public Object getItem(int i){
        return listItem.get(i);
    }

    @Override
    public long getItemId(int i){
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        view = LayoutInflater.from(this.fragment).inflate(R.layout.food_list_strings, parent , false);
        ViewHolder viewHolder = new ViewHolder(view);
        Food currentFood = (Food)this.getItem(i);
        viewHolder.updateView(currentFood);
        view.setTag(viewHolder);
        return view;
    }

    private class ViewHolder{
        protected TextView title;
        protected TextView details;
        protected int i;

        public ViewHolder(View view) {
            this.title = view.findViewById(R.id.list_item_string);
            this.details = view.findViewById(R.id.list_item_string_detail);
        }

        public void updateView(final Food food){
            this.title.setText(food.getTitle());
            this.details.setText(food.getDescription());
        }
    }
}
