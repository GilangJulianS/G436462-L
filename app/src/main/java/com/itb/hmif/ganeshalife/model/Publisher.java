package com.itb.hmif.ganeshalife.model;

import android.app.Activity;
import android.view.View;

import com.itb.hmif.ganeshalife.R;
import com.itb.hmif.ganeshalife.custom.PublisherHolder;
import com.itb.hmif.ganeshalife.recyclerviewframework.DataModel;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerAdapter;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerHolder;

/**
 * Created by Gilang on 12/04/2016.
 */
public class Publisher extends DataModel {

    public String publisherId;
    public String publisherName;
    public String publisherDetailName;
    public String publisherRating;
    public String contentMoveAndJob;
    public String contentProker;
    public boolean isFollowing;

    public Publisher(){}

    public Publisher(String publisherId, String publisherName){
        this.publisherId = publisherId;
        this.publisherName = publisherName;
    }

    public Publisher(String publisherId, String publisherName, String publisherDetailName,
                String publisherRating){
        this.publisherId = publisherId;
        this.publisherName = publisherName;
        this.publisherDetailName = publisherDetailName;
        this.publisherRating = publisherRating;
    }

    @Override
    public int getViewResId() {
        return R.layout.card_publisher;
    }

    @Override
    public RecyclerHolder createViewHolder(View v, Activity activity, RecyclerAdapter adapter) {
        return new PublisherHolder(v, activity, adapter);
    }
}
