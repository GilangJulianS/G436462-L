package com.itb.hmif.ganeshalife.fragment;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.itb.hmif.ganeshalife.model.ExploreCategory;
import com.itb.hmif.ganeshalife.recyclerviewframework.DataModel;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gilang on 25/04/2016.
 */
public class ExploreFragment extends RecyclerFragment {

	ExploreCategory exploreCategory;

	public ExploreFragment(){}

	public static ExploreFragment newInstance(AppCompatActivity activity, @Nullable ExploreCategory exploreCategory){
		ExploreFragment fragment = new ExploreFragment();
		fragment.activity = activity;
		fragment.exploreCategory = exploreCategory;
		return fragment;
	}

	@Override
	public int getColumnNumber() {
		return 2;
	}

	@Override
	public List<DataModel> getDatas() {
		if(exploreCategory == null || exploreCategory.childCategories.size() == 0){
			return getDummyData();
		}else{
			List<DataModel> datas = new ArrayList<>();
			for(ExploreCategory e : exploreCategory.childCategories){
				datas.add(e);
			}
			return datas;
		}
	}

	public List<DataModel> getDummyData(){
		List<DataModel> datas = new ArrayList<>();
		List<ExploreCategory> childs = new ArrayList<>();
		ExploreCategory category;
		childs.add(new ExploreCategory("01", "KABINET"));
		childs.add(new ExploreCategory("02", "MWA-WM"));
		childs.add(new ExploreCategory("03", "KONGRES"));
		childs.add(new ExploreCategory("04", "HMJ"));
		childs.add(new ExploreCategory("05", "UKM"));
		category = new ExploreCategory("0", "KM-ITB", childs);

		datas.add(category);
		datas.add(new ExploreCategory("1", "REKTORAT"));
		datas.add(new ExploreCategory("2", "INOVASI"));
		datas.add(new ExploreCategory("3", "POLITIK"));
		datas.add(new ExploreCategory("4", "HIBURAN"));
		datas.add(new ExploreCategory("5", "LOMBA"));

		return datas;
	}
}
