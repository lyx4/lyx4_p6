package com.example.lyx4_p6;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SpinnerItem {
    private String mActivity;
    private String mTime;

    public SpinnerItem(String activity, String time) {
        mActivity = activity;
        mTime = time;
    }

    public String getActivity() {
        return mActivity;
    }

    public String getTime() {
        return mTime;
    }
}
