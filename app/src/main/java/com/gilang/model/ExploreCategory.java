package com.gilang.model;

import android.app.Activity;
import android.view.View;

import com.gilang.custom.ExploreHolder;
import com.gilang.ganeshalife.R;
import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gilang on 25/04/2016.
 */
public class ExploreCategory extends DataModel {

	public String id;
	public String name;
	public List<ExploreCategory> childCategories;

	public ExploreCategory(String id, String name) {
		this.id = id;
		this.name = name;
		childCategories = new ArrayList<>();
	}

	public ExploreCategory(String id, String name, List<ExploreCategory> childCategories) {
		this.id = id;
		this.name = name;
		this.childCategories = childCategories;
	}

	public void addChild(ExploreCategory category){
		childCategories.add(category);
	}

	public void addChilds(List<ExploreCategory> categories){
		childCategories.addAll(categories);
	}

	@Override
	public int getViewResId() {
		return R.layout.card_topic;
	}

	@Override
	public RecyclerHolder createViewHolder(View v, Activity activity, RecyclerAdapter adapter) {
		return new ExploreHolder(v, activity, adapter);
	}
}
