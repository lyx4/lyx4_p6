package com.example.lyx4_p6;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataFragment extends Fragment {

    AnyChartView pieChart;
    Button shareButton;
    String[] activities = {"SLEEP", "CORNELL", "HYGIENE", "EAT", "SOCIAL", "PERSONAL PROJECTS", "EXERCISE", "MEDIA", "DRAW"};
    int[] frequency = {9, 5, 2, 2, 2, 1, 1, 1, 1};

    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_data, container, false);

        shareButton = (Button) rootView.findViewById(R.id.share_button);
        pieChart = rootView.findViewById(R.id.pie_chart);
        setupPieChart();

        final TextView date = rootView.findViewById(R.id.current_date);
        setDate(date);

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                String today = date.getText().toString();
                intent.putExtra(Intent.EXTRA_TEXT, "On " + today + ", I spent 37.5% of my day sleeping!");
                intent.setType("text/plain");
                startActivity(intent);
            }
        });

        return rootView;
    }

    public void setupPieChart() {
        Pie pie = AnyChart.pie();
        List<DataEntry> dataList = new ArrayList<> ();

        for (int i = 0; i < activities.length; i++) {
            dataList.add(new ValueDataEntry(activities[i], frequency[i]));
        }

        pie.data(dataList);
        pieChart.setChart(pie);

    }

    public void setDate (TextView view) {
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String current_date = formatter.format(today);
        view.setText(current_date);
    }
}
