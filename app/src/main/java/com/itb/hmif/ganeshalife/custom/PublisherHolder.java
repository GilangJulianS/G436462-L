package com.itb.hmif.ganeshalife.custom;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.itb.hmif.ganeshalife.R;
import com.itb.hmif.ganeshalife.model.Publisher;
import com.itb.hmif.ganeshalife.recyclerviewframework.DataModel;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerAdapter;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerHolder;

/**
 * Created by Gilang on 12/04/2016.
 */
public class PublisherHolder extends RecyclerHolder {

    public ImageView img;
    public TextView txtName;
    public TextView txtRating;

    public PublisherHolder(View v, Activity activity, RecyclerAdapter adapter) {
        super(v, activity, adapter);
        img = (ImageView) v.findViewById(R.id.img);
        txtName = (TextView) v.findViewById(R.id.txt_name);
        txtRating = (TextView) v.findViewById(R.id.txt_rating);
    }

    @Override
    public void bind(DataModel dataModel, Activity activity, int position) {
        Publisher p = (Publisher) dataModel;
//        img.setImageResource();
        txtName.setText(p.publisherName);
        txtRating.setText(p.publisherRating);
    }
}
