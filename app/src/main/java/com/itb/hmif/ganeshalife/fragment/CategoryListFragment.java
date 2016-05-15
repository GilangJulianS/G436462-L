package com.itb.hmif.ganeshalife.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itb.hmif.ganeshalife.R;
import com.itb.hmif.ganeshalife.controller.ExploreController;
import com.itb.hmif.ganeshalife.custom.OnVolleyCallback;
import com.itb.hmif.ganeshalife.model.Category;
import com.itb.hmif.ganeshalife.model.Publisher;
import com.itb.hmif.ganeshalife.recyclerviewframework.DataModel;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gilang on 26/04/2016.
 */
public class CategoryListFragment extends RecyclerFragment {

	LoadingDialog loadingDialog;
	ExploreController exploreController;

	public CategoryListFragment(){}

	public static CategoryListFragment newInstance(AppCompatActivity activity){
		CategoryListFragment fragment = new CategoryListFragment();
		fragment.activity = activity;
		return fragment;
	}

	@Override
	public void onCreateView(View v, ViewGroup parent, Bundle savedInstanceState) {
		super.onCreateView(v, parent, savedInstanceState);
		ViewGroup headerContainer = (ViewGroup) activity.findViewById(R.id.parallax_header);
		headerContainer.removeAllViews();
		LayoutInflater inflater = activity.getLayoutInflater();
		View header = inflater.inflate(R.layout.header_categorylist, parent, false);
		headerContainer.addView(header);
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

	public List<DataModel> getDummyDatas(){
		List<DataModel> datas = new ArrayList<>();

		datas.add(new Category(-1, "HMIF", "Himpunan Mahasiswa Informatika", false));
		datas.add(new Category(-1, "HMS", "Himpunan Mahasiswa Sipil", false));
		datas.add(new Category(-1, "HMP Pangriptaloka", "Himpunan Mahasiswa Planologi", false));
		datas.add(new Category(-1, "HIMAREKTA 'AGRAPANA'", "Himpunan Mahasiswa Rekayasa Pertanian", false));

		return datas;
	}
}
