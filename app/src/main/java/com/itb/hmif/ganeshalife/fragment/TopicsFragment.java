package com.itb.hmif.ganeshalife.fragment;

import android.support.v7.app.AppCompatActivity;

import com.itb.hmif.ganeshalife.model.AddTopic;
import com.itb.hmif.ganeshalife.model.Topic;
import com.itb.hmif.ganeshalife.recyclerviewframework.DataModel;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerFragment;

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
