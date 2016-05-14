package com.itb.hmif.ganeshalife.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;
import com.itb.hmif.ganeshalife.controller.MainController;
import com.itb.hmif.ganeshalife.controller.OnVolleyCallback;
import com.itb.hmif.ganeshalife.controller.ReadController;
import com.itb.hmif.ganeshalife.model.Post;
import com.itb.hmif.ganeshalife.recyclerviewframework.DataModel;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by macair on 3/26/16.
 * edited by Yanfa on 5/12/16
 */
public class HomeFragment extends RecyclerFragment {

    private AppCompatActivity activity;
    private ReadController readController;

    private LoadingDialog loadingDialog;
    private boolean isError;

    public HomeFragment(){}

    public static HomeFragment newInstance(AppCompatActivity activity){
        HomeFragment fragment = new HomeFragment();
        fragment.activity = activity;
        return fragment;
    }

    @Override
    public void onCreateView(View v, ViewGroup parent, Bundle savedInstanceState) {
        super.onCreateView(v, parent, savedInstanceState);
        isError = true;
	    RecyclerViewMaterialAdapter newAdapter = new RecyclerViewMaterialAdapter(adapter);
	    recyclerView.setAdapter(newAdapter);
        MaterialViewPagerHelper.registerRecyclerView(activity, recyclerView, null);
    }

    @Override
    public List<DataModel> getDatas() {

        List<DataModel> datas = new ArrayList<>();

        loadingDialog = new LoadingDialog();
        readController = new ReadController();
        loadingDialog.show(getFragmentManager(), "Loading");
        readController.getPostPerCategory(getActivity(), MainController.CURRENT_USER.getUserId(), Post.TYPE_HIGHLIGHT, 0, 10, new OnVolleyCallback() {
            @Override
            public void onSuccess(String result) {
                Post[] postRet = getPostFromJSON(result);
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
//        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
//        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
//        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
//        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
//        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
//        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
//        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
//        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
//        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
//        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
//        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
//        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
//        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
//        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
//        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
//        datas.add(new Post("1", "Judul Item", "", "4.5", "Content Here", "Berita", new Date()));
        return datas;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    private Post[] getPostFromJSON(String stringJSON){
        Post[] postRet = new Post[0];
        try {
            JSONObject jsonRet = new JSONObject(stringJSON);
            isError = jsonRet.getString("error").equals("true");
            if(!isError){
                JSONArray data = jsonRet.getJSONArray("data");
                postRet = new Post[data.length()];
                for(int i = 0; i < data.length(); i++) {
                    JSONObject currJSON = data.getJSONObject(i);

                    String postId = currJSON.getString("postId");
                    String title = currJSON.getString("title");
                    String content = currJSON.getString("content");
                    String rating = currJSON.getString("rating");
                    String imageUrl = currJSON.getString("imageUrl");

                    String time = currJSON.getString("postedAt");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                    Date postedAt = sdf.parse(time);
                    postRet[i] = new Post(postId, title, imageUrl, rating, content, "Highlight", postedAt);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return postRet;
    }
}
