package com.itb.hmif.ganeshalife.model;

import android.app.Activity;
import android.view.View;

import com.itb.hmif.ganeshalife.R;
import com.itb.hmif.ganeshalife.custom.AddTopicHolder;
import com.itb.hmif.ganeshalife.recyclerviewframework.DataModel;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerAdapter;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerHolder;

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
