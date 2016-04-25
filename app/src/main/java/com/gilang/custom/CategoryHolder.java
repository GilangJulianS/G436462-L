package com.gilang.custom;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gilang.fragment.ProfileFragment;
import com.gilang.ganeshalife.CollapseActivity;
import com.gilang.ganeshalife.R;
import com.gilang.model.Category;
import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;

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
