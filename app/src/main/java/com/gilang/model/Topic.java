package com.gilang.model;

import android.app.Activity;
import android.view.View;

import com.gilang.custom.TopicHolder;
import com.gilang.ganeshalife.R;
import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;

/**
 * Created by Gilang on 25/04/2016.
 */
public class Topic extends DataModel {

	public String topicId;
	public String topicName;

	public Topic(String topicId, String topicName) {
		this.topicId = topicId;
		this.topicName = topicName;
	}

	@Override
	public int getViewResId() {
		return R.layout.card_topic;
	}

	@Override
	public RecyclerHolder createViewHolder(View v, Activity activity, RecyclerAdapter adapter) {
		return new TopicHolder(v, activity, adapter);
	}
}
