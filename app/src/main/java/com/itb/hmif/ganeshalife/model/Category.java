package com.itb.hmif.ganeshalife.model;

import android.app.Activity;
import android.view.View;

import com.itb.hmif.ganeshalife.R;
import com.itb.hmif.ganeshalife.custom.CategoryHolder;
import com.itb.hmif.ganeshalife.recyclerviewframework.DataModel;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerAdapter;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerHolder;

/**
 * Created by Gilang on 26/04/2016.
 */
public class Category extends DataModel {

	public int imgRes;
	public String primary;
	public String secondary;
	public boolean isFavorited;

	public Category(int imgRes, String primary, String secondary, boolean isFavorited) {
		this.imgRes = imgRes;
		this.primary = primary;
		this.secondary = secondary;
		this.isFavorited = isFavorited;
	}

	@Override
	public int getViewResId() {
		return R.layout.card_category;
	}

	@Override
	public RecyclerHolder createViewHolder(View v, Activity activity, RecyclerAdapter adapter) {
		return new CategoryHolder(v, activity, adapter);
	}
}
