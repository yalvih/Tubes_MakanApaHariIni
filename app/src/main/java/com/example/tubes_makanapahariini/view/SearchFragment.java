package com.example.tubes_makanapahariini.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;

import com.example.tubes_makanapahariini.DBHandler;
import com.example.tubes_makanapahariini.R;
import com.example.tubes_makanapahariini.model.Food;
import com.example.tubes_makanapahariini.presenter.SearchPresenter;

import java.util.List;

// Search fragment

public class SearchFragment extends Fragment implements AdapterView.OnItemClickListener, SearchPresenter.ISearchPresenter {
    DBHandler dbHandler;
    FragmentListener fragmentListener;
    SearchPresenter searchPresenter;
    SearchFragmentAdapter searchFragmentAdapter;
    ListView list_view;
    SearchView search;

    public SearchFragment(){}

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment, container, false);

        this.dbHandler = new DBHandler(this.getContext());
        this.searchPresenter = new SearchPresenter(this, this.dbHandler);
        this.search = view.findViewById(R.id.search);
        this.list_view = view.findViewById(R.id.list_foods);

        this.searchFragmentAdapter = new SearchFragmentAdapter(this.getActivity());
        this.list_view.setAdapter(this.searchFragmentAdapter);
        this.list_view.setOnItemClickListener(this);

        this.search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                search.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchPresenter.loadData(newText);
                return true;
            }
        });
        searchPresenter.loadData("");
        
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
    public void UpdateList(List<Food> data) {
        searchFragmentAdapter.updateList(data);
        searchFragmentAdapter.notifyDataSetChanged();
    }

    @Override
    public void openDetails(int id) {
        this.fragmentListener.changeMenuId(id);
        this.fragmentListener.changePage(6);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        this.searchPresenter.openDetails(i);
    }
}
