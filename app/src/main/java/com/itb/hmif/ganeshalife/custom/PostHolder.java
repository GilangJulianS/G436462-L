package com.itb.hmif.ganeshalife.custom;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.itb.hmif.ganeshalife.R;
import com.itb.hmif.ganeshalife.activity.CollapseActivity;
import com.itb.hmif.ganeshalife.model.Post;
import com.itb.hmif.ganeshalife.recyclerviewframework.DataModel;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerAdapter;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerHolder;

/**
 * Created by macair on 3/26/16.
 */
public class PostHolder extends RecyclerHolder {

	public ImageView image;
	public TextView txtTitle, txtPublisher, txtRating, txtTime;
	public CardView card;

	public PostHolder(View v, Activity activity, RecyclerAdapter adapter) {
		super(v, activity, adapter);
		image = (ImageView) v.findViewById(R.id.img);
		txtTitle = (TextView) v.findViewById(R.id.txt_title);
		txtPublisher = (TextView) v.findViewById(R.id.txt_publisher);
		txtRating = (TextView) v.findViewById(R.id.txt_rating);
		txtTime = (TextView) v.findViewById(R.id.txt_time);
		card = (CardView) v.findViewById(R.id.card);
	}

	@Override
	public void bind(DataModel dataModel, final Activity activity, int position) {
		Post post = (Post) dataModel;
//		image.setImageResource();
		txtTitle.setText(post.title);
//		txtPublisher.setText();
		txtRating.setText(post.postRating);
		txtTime.setText(post.postedAt.toString());

		card.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(activity, CollapseActivity.class);
				i.putExtra(Value.FRAGMENT_TYPE, Value.FRAGMENT_DETAIL);
				activity.startActivity(i);
			}
		});
	}
}
