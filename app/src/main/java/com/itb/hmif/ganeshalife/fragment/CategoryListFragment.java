package com.itb.hmif.ganeshalife.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itb.hmif.ganeshalife.R;
import com.itb.hmif.ganeshalife.model.Category;
import com.itb.hmif.ganeshalife.recyclerviewframework.DataModel;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gilang on 26/04/2016.
 */
public class CategoryListFragment extends RecyclerFragment {

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

		datas.add(new Category(-1, "HMIF", "Himpunan Mahasiswa Informatika", false));
		datas.add(new Category(-1, "HMS", "Himpunan Mahasiswa Sipil", false));
		datas.add(new Category(-1, "HMP Pangriptaloka", "Himpunan Mahasiswa Planologi", false));
		datas.add(new Category(-1, "HIMAREKTA 'AGRAPANA'", "Himpunan Mahasiswa Rekayasa Pertanian", false));

		return datas;
	}
}
