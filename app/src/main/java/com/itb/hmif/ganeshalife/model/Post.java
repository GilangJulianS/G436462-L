package com.itb.hmif.ganeshalife.model;

import android.app.Activity;
import android.view.View;


import com.itb.hmif.ganeshalife.R;
import com.itb.hmif.ganeshalife.custom.PostHolder;
import com.itb.hmif.ganeshalife.recyclerviewframework.DataModel;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerAdapter;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerHolder;

import java.util.Date;

/**
 * Created by macair on 3/26/16.
 */
public class Post extends DataModel {

    public static final int TYPE_HIGHLIGHT = 1;
    public static final int TYPE_LOMBA = 2;
    public static final int TYPE_ACARA = 3;
    public static final int TYPE_BEASISWA = 4;
    public static final int TYPE_ISUKAMPUS = 5;

    public String postId;
    public String title;
    public String imageUrl;
    public String postRating;
    public String content;
    public String category;
    public Date postedAt;
//    public Publisher publisher;

    Post(){}

    public Post(String postId, String title, String imageUrl, String postRating, String content, String category, Date postedAt) {
        this.postId = postId;
        this.title = title;
        this.imageUrl = imageUrl;
        this.postRating = postRating;
        this.content = content;
        this.category = category;
        this.postedAt = postedAt;
    }

    @Override
    public int getViewResId() {
        return R.layout.card_post;
    }

    @Override
    public RecyclerHolder createViewHolder(View v, Activity activity, RecyclerAdapter adapter) {
        return new PostHolder(v, activity, adapter);
    }
}
