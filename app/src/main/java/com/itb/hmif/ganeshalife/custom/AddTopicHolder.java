package com.itb.hmif.ganeshalife.custom;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.itb.hmif.ganeshalife.R;
import com.itb.hmif.ganeshalife.recyclerviewframework.DataModel;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerAdapter;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerHolder;

/**
 * Created by Gilang on 25/04/2016.
 */
public class AddTopicHolder extends RecyclerHolder {

	public ImageView img;

	public AddTopicHolder(View v, Activity activity, RecyclerAdapter adapter) {
		super(v, activity, adapter);
		img = (ImageView) v.findViewById(R.id.img);
	}

	@Override
	public void bind(DataModel dataModel, final Activity activity, int position) {
		img.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				addTopic(activity);
			}
		});
	}

	public void addTopic(Activity activity){
		Toast.makeText(activity, "Add topic clicked", Toast.LENGTH_SHORT).show();
	}
}
