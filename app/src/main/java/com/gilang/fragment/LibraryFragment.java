package com.gilang.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.gilang.custom.LibraryPagerAdapter;
import com.gilang.ganeshalife.R;

/**
 * Created by Gilang on 25/04/2016.
 */
public class LibraryFragment extends Fragment {

	AppCompatActivity activity;
	ViewPager pager;
	PagerSlidingTabStrip pagerTab;

	public LibraryFragment(){}

	public static LibraryFragment newInstance(AppCompatActivity activity){
		LibraryFragment fragment = new LibraryFragment();
		fragment.activity = activity;
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.fragment_library, parent, false);

		bindViews(v);

		return v;
	}

	public void bindViews(View v){
		pager = (ViewPager) v.findViewById(R.id.view_pager);
		pagerTab = (PagerSlidingTabStrip) v.findViewById(R.id.pager_tab);
		LibraryPagerAdapter adapter = new LibraryPagerAdapter(activity);
		pager.setAdapter(adapter);
		pagerTab.setViewPager(pager);
	}
}
