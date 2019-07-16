package com.example.demoswiper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList <Fragment> al;
    MyFragmentPagerAdapter adapter;
    ViewPager vPager;

    Button btnBack, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vPager = findViewById(R.id.viewpager1);

        btnBack = findViewById(R.id.btnBack);
        btnNext = findViewById(R.id.btnNext);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vPager.getCurrentItem() > 0){
                    int previousPage = vPager.getCurrentItem() - 1;
                    vPager.setCurrentItem(previousPage, true);
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int max = vPager.getChildCount();
                if (vPager.getCurrentItem() < max-1){
                    int nextPage = vPager.getCurrentItem() + 1;
                    vPager.setCurrentItem(nextPage, true);
                }
            }
        });
    }
}


