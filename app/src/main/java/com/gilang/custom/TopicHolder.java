package com.gilang.custom;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gilang.ganeshalife.R;
import com.gilang.model.Topic;
import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;

/**
 * Created by Gilang on 25/04/2016.
 */
public class TopicHolder extends RecyclerHolder {

	public ImageView img;
	public TextView txt;

	public TopicHolder(View v, Activity activity, RecyclerAdapter adapter) {
		super(v, activity, adapter);
		img = (ImageView) v.findViewById(R.id.img);
		txt = (TextView) v.findViewById(R.id.txt);
	}

	@Override
	public void bind(DataModel dataModel, Activity activity, int position) {
		Topic t = (Topic) dataModel;
//		img.setImageResource();
		txt.setText(t.topicName);
	}
}
