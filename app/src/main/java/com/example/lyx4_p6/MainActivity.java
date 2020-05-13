package com.example.lyx4_p6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button gridTab = findViewById(R.id.grid_tab);
        Button dataTab = findViewById(R.id.data_tab);
        Button shibaTab = findViewById(R.id.shiba_tab);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        GridFragment fragment = new GridFragment();
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

        gridTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GridFragment fragment = new GridFragment();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        dataTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataFragment fragment = new DataFragment();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        shibaTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShibaFragment fragment = new ShibaFragment();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });
    }
}
