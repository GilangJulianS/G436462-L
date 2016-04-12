package com.gilang.fragment;

import android.support.v7.app.AppCompatActivity;

import com.gilang.model.Post;
import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerFragment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Gilang on 12/04/2016.
 */
public class BookmarkFragment extends RecyclerFragment {

    public BookmarkFragment(){}

    public static BookmarkFragment newInstance(AppCompatActivity activity){
        BookmarkFragment fragment = new BookmarkFragment();
        fragment.activity = activity;
        return fragment;
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
}
