package com.gilang.model;

import android.app.Activity;
import android.view.View;

import com.gilang.custom.CategoryHolder;
import com.gilang.ganeshalife.R;
import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;

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
