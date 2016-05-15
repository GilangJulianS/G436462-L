package com.itb.hmif.ganeshalife.fragment;

import android.support.v7.app.AppCompatActivity;

import com.itb.hmif.ganeshalife.controller.ExploreController;
import com.itb.hmif.ganeshalife.custom.OnVolleyCallback;
import com.itb.hmif.ganeshalife.model.AddTopic;
import com.itb.hmif.ganeshalife.model.Publisher;
import com.itb.hmif.ganeshalife.model.Topic;
import com.itb.hmif.ganeshalife.recyclerviewframework.DataModel;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gilang on 25/04/2016.
 */
public class TopicsFragment extends RecyclerFragment {

	LoadingDialog loadingDialog;
	ExploreController exploreController;

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

		loadingDialog = new LoadingDialog();
		exploreController = new ExploreController();
		loadingDialog.show(getFragmentManager(), "Loading");
		exploreController.getAvailablePublisher(getActivity(), new OnVolleyCallback() {
			@Override
			public void onSuccess(String result) {
				Publisher[] postRet = exploreController.getPublishersFromJson(result);
				for(int i = 0; i < postRet.length; i++){
					adapter.add(postRet[i]);
				}
				adapter.notifyDataSetChanged();
				loadingDialog.dismiss();
			}

			@Override
			public void onError(String errorResult) {
				loadingDialog.dismiss();
			}
		});
//		datas = getDummyDatas();
		return datas;
	}

	public List<DataModel> getDummyDatas() {
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
