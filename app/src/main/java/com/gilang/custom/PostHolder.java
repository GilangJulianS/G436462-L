package com.gilang.custom;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gilang.ganeshalife.R;
import com.gilang.model.Post;
import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;

/**
 * Created by macair on 3/26/16.
 */
public class PostHolder extends RecyclerHolder {

	public ImageView image;
	public TextView txtTitle, txtPublisher, txtRating, txtTime;

	public PostHolder(View v, Activity activity, RecyclerAdapter adapter) {
		super(v, activity, adapter);
		image = (ImageView) v.findViewById(R.id.img);
		txtTitle = (TextView) v.findViewById(R.id.txt_title);
		txtPublisher = (TextView) v.findViewById(R.id.txt_publisher);
		txtRating = (TextView) v.findViewById(R.id.txt_rating);
		txtTime = (TextView) v.findViewById(R.id.txt_time);
	}

	@Override
	public void bind(DataModel dataModel, Activity activity, int position) {
		Post post = (Post) dataModel;
//		image.setImageResource();
		txtTitle.setText(post.title);
//		txtPublisher.setText();
		txtRating.setText(post.postRating);
		txtTime.setText(post.postedAt.toString());
	}
}
