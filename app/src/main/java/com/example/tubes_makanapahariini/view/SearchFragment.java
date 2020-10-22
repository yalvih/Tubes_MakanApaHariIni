package com.example.tubes_makanapahariini.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;

import com.example.tubes_makanapahariini.R;
import com.example.tubes_makanapahariini.model.Food;
import com.example.tubes_makanapahariini.presenter.SearchPresenter;

import java.util.List;

//SEACRH FRAGMENT

public class SearchFragment extends Fragment implements SearchPresenter.ISearchPresenter, ViewGroup.OnClickListener {
    SearchView search;
    ListView list_view;
    SearchFragmentAdapter searchFragmentAdapter;
    SearchPresenter searchPresenter;
    FragmentListener fragmentListener;

    public SearchFragment(){}

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment, container, false);
        this.search = view.findViewById(R.id.search);
        this.list_view = view.findViewById(R.id.list_foods);
        this.searchPresenter = new SearchPresenter(this);

        this.searchFragmentAdapter = new SearchFragmentAdapter(this.getActivity());
        this.list_view.setAdapter(this.searchFragmentAdapter);
        searchPresenter.loadData();
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
    public void UpdateList(List<Food> data) {
        searchFragmentAdapter.updateList(data);
        searchFragmentAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {

    }
}
