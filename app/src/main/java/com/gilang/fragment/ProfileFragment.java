package com.gilang.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gilang.ganeshalife.R;


/**
 * Created by Gilang on 26/04/2016.
 */
public class ProfileFragment extends Fragment {

	AppCompatActivity activity;
	ImageView imgBackground, logo;
	ViewGroup infoContainer;

	public ProfileFragment(){}

	public static ProfileFragment newInstance(AppCompatActivity activity){
		ProfileFragment fragment = new ProfileFragment();
		fragment.activity = activity;
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.fragment_profile, parent, false);

		bindViews(v);
		addHeader(inflater);

		return v;
	}

	public void bindViews(View v){

	}

	public void addHeader(LayoutInflater inflater){
		ViewGroup headerContainer = (ViewGroup) activity.findViewById(R.id.parallax_header);
		headerContainer.removeAllViews();
		View header = inflater.inflate(R.layout.header_profile, headerContainer, false);
		imgBackground = (ImageView) header.findViewById(R.id.img);
		logo = (ImageView) header.findViewById(R.id.logo);
		headerContainer.addView(header);
	}
}
