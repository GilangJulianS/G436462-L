package com.itb.hmif.ganeshalife.fragment;

import android.support.v7.app.AppCompatActivity;

import com.itb.hmif.ganeshalife.controller.ExploreController;
import com.itb.hmif.ganeshalife.custom.OnVolleyCallback;
import com.itb.hmif.ganeshalife.model.Publisher;
import com.itb.hmif.ganeshalife.recyclerviewframework.DataModel;
import com.itb.hmif.ganeshalife.recyclerviewframework.RecyclerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gilang on 12/04/2016.
 */
public class PublisherFragment extends RecyclerFragment {

    LoadingDialog loadingDialog;
    ExploreController exploreController;

    public PublisherFragment(){}

    public static PublisherFragment newInstance(AppCompatActivity activity){
        PublisherFragment fragment = new PublisherFragment();
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

//        datas = getDummyDatas();

        return datas;
    }

    public List<DataModel> getDummyDatas() {
        List<DataModel> datas = new ArrayList<>();

        datas.add(new Publisher("0", "HMIF", "Himpunan Mahasiswa Informatika", "4.5"));
        datas.add(new Publisher("1", "HIMAREKTA", "Himpunan Mahasiswa Informatika", "4.5"));
        datas.add(new Publisher("2", "IPPDIG", "Himpunan Mahasiswa Informatika", "4.5"));
        datas.add(new Publisher("3", "INDDES", "Himpunan Mahasiswa Informatika", "4.5"));
        datas.add(new Publisher("4", "VASA", "Himpunan Mahasiswa Informatika", "4.5"));
        datas.add(new Publisher("0", "HMIF", "Himpunan Mahasiswa Informatika", "4.5"));
        datas.add(new Publisher("1", "HIMAREKTA", "Himpunan Mahasiswa Informatika", "4.5"));
        datas.add(new Publisher("2", "IPPDIG", "Himpunan Mahasiswa Informatika", "4.5"));
        datas.add(new Publisher("3", "INDDES", "Himpunan Mahasiswa Informatika", "4.5"));
        datas.add(new Publisher("4", "VASA", "Himpunan Mahasiswa Informatika", "4.5"));
        datas.add(new Publisher("0", "HMIF", "Himpunan Mahasiswa Informatika", "4.5"));
        datas.add(new Publisher("1", "HIMAREKTA", "Himpunan Mahasiswa Informatika", "4.5"));
        datas.add(new Publisher("2", "IPPDIG", "Himpunan Mahasiswa Informatika", "4.5"));
        datas.add(new Publisher("3", "INDDES", "Himpunan Mahasiswa Informatika", "4.5"));
        datas.add(new Publisher("4", "VASA", "Himpunan Mahasiswa Informatika", "4.5"));
        datas.add(new Publisher("0", "HMIF", "Himpunan Mahasiswa Informatika", "4.5"));
        datas.add(new Publisher("1", "HIMAREKTA", "Himpunan Mahasiswa Informatika", "4.5"));
        datas.add(new Publisher("2", "IPPDIG", "Himpunan Mahasiswa Informatika", "4.5"));
        datas.add(new Publisher("3", "INDDES", "Himpunan Mahasiswa Informatika", "4.5"));
        datas.add(new Publisher("4", "VASA", "Himpunan Mahasiswa Informatika", "4.5"));
        datas.add(new Publisher("0", "HMIF", "Himpunan Mahasiswa Informatika", "4.5"));
        datas.add(new Publisher("1", "HIMAREKTA", "Himpunan Mahasiswa Informatika", "4.5"));
        datas.add(new Publisher("2", "IPPDIG", "Himpunan Mahasiswa Informatika", "4.5"));
        datas.add(new Publisher("3", "INDDES", "Himpunan Mahasiswa Informatika", "4.5"));
        datas.add(new Publisher("4", "VASA", "Himpunan Mahasiswa Informatika", "4.5"));

        return datas;
    }
}
