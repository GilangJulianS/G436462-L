package com.gilang.model;

import android.app.Activity;
import android.view.View;

import com.gilang.custom.AddTopicHolder;
import com.gilang.ganeshalife.R;
import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;

/**
 * Created by Gilang on 25/04/2016.
 */
public class AddTopic extends DataModel {

	@Override
	public int getViewResId() {
		return R.layout.card_add_topic;
	}

	@Override
	public RecyclerHolder createViewHolder(View v, Activity activity, RecyclerAdapter adapter) {
		return new AddTopicHolder(v, activity, adapter);
	}
}
