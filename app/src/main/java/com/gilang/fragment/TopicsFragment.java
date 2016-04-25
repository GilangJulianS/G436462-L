package com.gilang.fragment;

import android.support.v7.app.AppCompatActivity;

import com.gilang.model.AddTopic;
import com.gilang.model.Topic;
import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gilang on 25/04/2016.
 */
public class TopicsFragment extends RecyclerFragment {

	public TopicsFragment(){}

	public static TopicsFragment newInstance(AppCompatActivity activity){
		TopicsFragment fragment = new TopicsFragment();
		fragment.activity = activity;
		return fragment;
	}

	@Override
	public int getColumnNumber() {
		return 3;
	}

	@Override
	public List<DataModel> getDatas() {
		List<DataModel> datas = new ArrayList<>();
		datas.add(new Topic("0", "PENELITIAN"));
		datas.add(new Topic("1", "TEKNOLOGI"));
		datas.add(new Topic("2", "PRESTASI"));
		datas.add(new Topic("3", "HIBURAN"));
		datas.add(new Topic("4", "OLAHRAGA"));
		datas.add(new AddTopic());
		return datas;
	}
}
