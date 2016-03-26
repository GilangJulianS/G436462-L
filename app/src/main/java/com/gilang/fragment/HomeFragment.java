package com.gilang.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gilang.ganeshalife.R;
import com.gilang.model.Post;
import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerFragment;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by macair on 3/26/16.
 */
public class HomeFragment extends RecyclerFragment {

    private AppCompatActivity activity;

    public HomeFragment(){}

    public static HomeFragment newInstance(AppCompatActivity activity){
        HomeFragment fragment = new HomeFragment();
        fragment.activity = activity;
        return fragment;
    }

    @Override
    public void onCreateView(View v, ViewGroup parent, Bundle savedInstanceState) {
        super.onCreateView(v, parent, savedInstanceState);
	    RecyclerViewMaterialAdapter newAdapter = new RecyclerViewMaterialAdapter(adapter);
	    recyclerView.setAdapter(newAdapter);
        MaterialViewPagerHelper.registerRecyclerView(activity, recyclerView, null);
    }

    @Override
    public List<DataModel> getDatas() {
        List<DataModel> datas = new ArrayList<>();

        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
        return datas;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
