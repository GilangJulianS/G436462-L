package com.gilang.custom;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.gilang.fragment.PublisherFragment;
import com.gilang.fragment.TopicsFragment;
import com.gilang.model.Publisher;

/**
 * Created by Gilang on 25/04/2016.
 */
public class LibraryPagerAdapter extends FragmentStatePagerAdapter {

	AppCompatActivity activity;

	public LibraryPagerAdapter(AppCompatActivity activity) {
		super(activity.getSupportFragmentManager());
		this.activity = activity;
	}

	@Override
	public Fragment getItem(int position) {
		if(position == 0){
			return PublisherFragment.newInstance(activity);
		}else{
			return TopicsFragment.newInstance(activity);
		}
	}

	@Override
	public CharSequence getPageTitle(int position) {
		if(position == 0){
			return "Publisher";
		}else{
			return  "Topics";
		}
	}

	@Override
	public int getCount() {
		return 2;
	}
}
