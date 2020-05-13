package com.example.lyx4_p6;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class GridFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public GridFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_grid, container, false);

        Context context = getActivity();

        TextView date = rootView.findViewById(R.id.current_date);
        setDate(date);

        ArrayList<SpinnerItem> spinnerList = new ArrayList<>();
        spinnerList.add(new SpinnerItem("SLEEP", "0000"));
        spinnerList.add(new SpinnerItem("SLEEP", "0100"));
        spinnerList.add(new SpinnerItem("SLEEP", "0200"));
        spinnerList.add(new SpinnerItem("SLEEP", "0300"));
        spinnerList.add(new SpinnerItem("SLEEP", "0400"));
        spinnerList.add(new SpinnerItem("SLEEP", "0500"));
        spinnerList.add(new SpinnerItem("SLEEP", "0600"));
        spinnerList.add(new SpinnerItem("HYGIENE", "0700"));
        spinnerList.add(new SpinnerItem("MEDIA", "0800"));
        spinnerList.add(new SpinnerItem("CORNELL", "0900"));
        spinnerList.add(new SpinnerItem("CORNELL", "1000"));
        spinnerList.add(new SpinnerItem("CORNELL", "1100"));
        spinnerList.add(new SpinnerItem("EAT", "1200"));
        spinnerList.add(new SpinnerItem("CORNELL", "1300"));
        spinnerList.add(new SpinnerItem("PERSONAL PROJECTS", "1400"));
        spinnerList.add(new SpinnerItem("EXERCISE", "1500"));
        spinnerList.add(new SpinnerItem("SOCIAL", "1600"));
        spinnerList.add(new SpinnerItem("SOCIAL", "1700"));
        spinnerList.add(new SpinnerItem("CORNELL", "1800"));
        spinnerList.add(new SpinnerItem("EAT", "1900"));
        spinnerList.add(new SpinnerItem("DRAW", "2000"));
        spinnerList.add(new SpinnerItem("HYGIENE", "2100"));
        spinnerList.add(new SpinnerItem("SLEEP", "2200"));
        spinnerList.add(new SpinnerItem("SLEEP", "2300"));


        mRecyclerView = rootView.findViewById(R.id.main_rv);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(context);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new CustomAdapter(spinnerList);
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    public void setDate (TextView view) {
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String current_date = formatter.format(today);
        view.setText(current_date);
    }

}

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private ArrayList<SpinnerItem> mSpinnerList;

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView mActivity;
        public TextView mTime;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            mActivity = itemView.findViewById(R.id.activity);
            mTime = itemView.findViewById(R.id.time);
        }
    }

    public CustomAdapter(ArrayList<SpinnerItem> spinnerList) {
        mSpinnerList = spinnerList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.spinner_item, parent, false);
        CustomViewHolder cvh = new CustomViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        SpinnerItem currentItem = mSpinnerList.get(position);

        holder.mActivity.setText(currentItem.getActivity());
        holder.mTime.setText(currentItem.getTime());
    }

    @Override
    public int getItemCount() {
        return mSpinnerList.size();
    }
}