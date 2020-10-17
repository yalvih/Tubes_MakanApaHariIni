package com.example.tubes_makanapahariini;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FoodListAdapter extends BaseAdapter {
    private List<String> listItem;
    private Activity activity;

    public FoodListAdapter(Activity activity) {
        this.activity = activity;
        this.listItem = new ArrayList<String>();
    }

    public void add(String newItem) {
        this.listItem.add(newItem);
        this.notifyDataSetChanged();
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
    public View getView(int i, View view, ViewGroup viewGroup){
        View itemView = this.activity.getLayoutInflater().inflate(R.layout.food_list_strings, null);
        TextView tvName = itemView.findViewById(R.id.food_item_string);
        tvName.setText(this.listItem.get(i));
        return itemView;
    }
}
