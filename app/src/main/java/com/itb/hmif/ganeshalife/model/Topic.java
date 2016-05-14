package com.itb.hmif.ganeshalife.model;

import android.app.Activity;
import android.view.View;

import com.itb.hmif.ganeshalife.R;
import com.itb.hmif.ganeshalife.custom.TopicHolder;
import com.itb.hmif.ganeshalife.recyclerviewframework.DataModel;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerAdapter;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerHolder;


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
