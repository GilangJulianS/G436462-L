package com.gilang.custom;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.gilang.fragment.HomeFragment;

/**
 * Created by macair on 3/26/16.
 */
public class CustomPagerAdapter extends FragmentStatePagerAdapter {

	private AppCompatActivity activity;

	public CustomPagerAdapter(FragmentManager fm, AppCompatActivity activity) {
		super(fm);
		this.activity = activity;
	}

	@Override
	public Fragment getItem(int position) {
		return HomeFragment.newInstance(activity);
	}

	@Override
	public CharSequence getPageTitle(int position) {
		switch (position){
			case 0:
				return "Highlights";
			case 1:
				return "Lomba";
			case 2:
				return "Acara";
			case 3:
				return "Beasiswa";
			case 4:
				return "Isu Kampus";
			default:
				return "";
		}
	}

	@Override
	public int getCount() {
		return 5;
	}
}
