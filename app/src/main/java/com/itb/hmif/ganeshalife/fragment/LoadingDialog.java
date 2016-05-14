package com.itb.hmif.ganeshalife.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.itb.hmif.ganeshalife.R;

/**
 * Created by Yanfa on 5/12/2016.
 */
public class LoadingDialog extends DialogFragment {

    private Dialog dialog;
    public static boolean finishRetreiving;
    private LinearLayout loadingLayout;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dialog = new Dialog(getActivity());
        finishRetreiving = false;
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.loading_layout);
        dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        loadingLayout = (LinearLayout)dialog.findViewById(R.id.loadingLayout);
        loadingLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getActivity().finish();
            }

        });

        return dialog;
    }
}

