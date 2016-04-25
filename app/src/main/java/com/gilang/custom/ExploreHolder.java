package com.gilang.custom;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gilang.fragment.ExploreFragment;
import com.gilang.ganeshalife.R;
import com.gilang.model.ExploreCategory;
import com.gilang.model.Topic;
import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;

/**
 * Created by Gilang on 25/04/2016.
 */
public class ExploreHolder extends RecyclerHolder {

	public ImageView img;
	public TextView txt;
	public ViewGroup card;

	public ExploreHolder(View v, Activity activity, RecyclerAdapter adapter) {
		super(v, activity, adapter);
		img = (ImageView) v.findViewById(R.id.img);
		txt = (TextView) v.findViewById(R.id.txt);
		card = (ViewGroup) v.findViewById(R.id.card);
	}

	@Override
	public void bind(DataModel dataModel, final Activity activity, int position) {
		final ExploreCategory ec = (ExploreCategory) dataModel;
//		img.setImageResource();
		card.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(ec.childCategories.size() > 0){
					gotoSpecificCategories(activity, ec);
				}else{
					gotoCategoryList(activity);
				}
			}
		});
		txt.setText(ec.name);
	}

	public void gotoSpecificCategories(Activity activity, ExploreCategory category){
		AppCompatActivity act = (AppCompatActivity) activity;
		act.getSupportFragmentManager().beginTransaction()
				.replace(R.id.container, ExploreFragment.newInstance(act, category))
				.addToBackStack(null)
				.commit();
	}

	public void gotoCategoryList(Activity activity){

	}
}
