package com.itb.hmif.ganeshalife.fragment;

import android.support.v7.app.AppCompatActivity;

import com.itb.hmif.ganeshalife.controller.MainController;
import com.itb.hmif.ganeshalife.controller.ReadController;
import com.itb.hmif.ganeshalife.custom.OnVolleyCallback;
import com.itb.hmif.ganeshalife.model.Post;
import com.itb.hmif.ganeshalife.recyclerviewframework.DataModel;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerFragment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Gilang on 12/04/2016.
 */
public class BookmarkFragment extends RecyclerFragment {

    LoadingDialog loadingDialog;
    ReadController readController;

    public BookmarkFragment(){}

    public static BookmarkFragment newInstance(AppCompatActivity activity){
        BookmarkFragment fragment = new BookmarkFragment();
        fragment.activity = activity;
        return fragment;
    }

    @Override
    public List<DataModel> getDatas() {
        List<DataModel> datas = new ArrayList<>();

        loadingDialog = new LoadingDialog();
        readController = new ReadController();
        loadingDialog.show(getFragmentManager(), "Loading");
        readController.getMyBookmarkPost(getActivity(), MainController.CURRENT_USER.getUserId(), 0, 10, new OnVolleyCallback() {
            @Override
            public void onSuccess(String result) {
                Post[] postRet = readController.getPostsFromJSON(result);
                for(int i = 0; i < postRet.length; i++){
                    adapter.add(postRet[i]);
                }
                adapter.notifyDataSetChanged();
                loadingDialog.dismiss();
            }

            @Override
            public void onError(String errorResult) {
                loadingDialog.dismiss();
            }
        });

//        datas = getDummyDatas();

        return datas;
    }

    public List<DataModel> getDummyDatas() {
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
