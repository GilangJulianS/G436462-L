package com.itb.hmif.ganeshalife.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itb.hmif.ganeshalife.R;

/**
 * Created by Gilang on 12/04/2016.
 */
public class DetailFragment extends Fragment {

    private AppCompatActivity activity;

    public DetailFragment(){}

    public static DetailFragment newInstance(AppCompatActivity activity){
        DetailFragment fragment = new DetailFragment();
        fragment.activity = activity;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_detail, parent, false);

        return v;
    }

    public void bindViews(View v){

    }

    public void loadData(){

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof AppCompatActivity){
            activity = (AppCompatActivity) context;
            ViewGroup headerContainer = (ViewGroup) activity.findViewById(R.id.parallax_header);
            LayoutInflater inflater = activity.getLayoutInflater();
            View header = inflater.inflate(R.layout.header_detail, headerContainer, false);
            headerContainer.addView(header);
        }
    }
}
