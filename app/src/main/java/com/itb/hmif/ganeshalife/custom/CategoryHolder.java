package com.itb.hmif.ganeshalife.custom;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.itb.hmif.ganeshalife.R;
import com.itb.hmif.ganeshalife.activity.CollapseActivity;
import com.itb.hmif.ganeshalife.model.Category;
import com.itb.hmif.ganeshalife.recyclerviewframework.DataModel;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerAdapter;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerHolder;

/**
 * Created by Gilang on 26/04/2016.
 */
public class CategoryHolder extends RecyclerHolder {

	public ImageView img, imgCheck;
	public TextView txtPrimary, txtSecondary;
	public CardView card;

	public CategoryHolder(View v, Activity activity, RecyclerAdapter adapter) {
		super(v, activity, adapter);
		img = (ImageView) v.findViewById(R.id.img);
		imgCheck = (ImageView) v.findViewById(R.id.img_check);
		txtPrimary = (TextView) v.findViewById(R.id.txt_primary);
		txtSecondary = (TextView) v.findViewById(R.id.txt_secondary);
		card = (CardView) v.findViewById(R.id.card);
	}

	@Override
	public void bind(DataModel dataModel, final Activity activity, int position) {
		Category c = (Category) dataModel;
		if(c.imgRes != -1)
			img.setImageResource(c.imgRes);
		txtPrimary.setText(c.primary);
		txtSecondary.setText(c.secondary);
		card.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				gotoDetail(activity);
			}
		});
	}

	public void gotoDetail(Activity activity){
		Intent i = new Intent(activity, CollapseActivity.class);
		i.putExtra(Value.FRAGMENT_TYPE, Value.FRAGMENT_PROFILE);
		activity.startActivity(i);
	}
}
