package com.example.knowyourfacts;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList <Fragment> al;
    MyFragmentPagerAdapter adapter;
    ViewPager vPager;
    Integer currentPage;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vPager = findViewById(R.id.viewpager1);

        btnBack = findViewById(R.id.btnBack);

        FragmentManager fm = getSupportFragmentManager();

        al = new ArrayList<>();
        al.add(new FragPrev());
        al.add(new FragCurr());
        al.add(new FragNext());

        adapter = new MyFragmentPagerAdapter(fm, al);

        vPager.setAdapter(adapter);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                Intent i = new Intent(MainActivity.this, MyReceiver.class);
                PendingIntent pIntent = PendingIntent.getBroadcast(MainActivity.this, 1, i, 0);
                Calendar now = Calendar.getInstance();
                now.add(Calendar.MINUTE, 5);
                am.set(AlarmManager.RTC_WAKEUP, now.getTimeInMillis(), pIntent);
                finish();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_prev) {
            if (vPager.getCurrentItem() > 0){
                int previousPage = vPager.getCurrentItem() - 1;
                vPager.setCurrentItem(previousPage, true);
            }
        } else if (item.getItemId() == R.id.action_random) {
            Random r = new Random();
            int page = r.nextInt(vPager.getChildCount());
            vPager.setCurrentItem(page, true);
        } else if (item.getItemId() == R.id.action_next) {
            int max = vPager.getChildCount();
            if (vPager.getCurrentItem() < max-1){
                int nextPage = vPager.getCurrentItem() + 1;
                vPager.setCurrentItem(nextPage, true);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        currentPage = vPager.getCurrentItem();
        prefEdit.putInt("current", currentPage);
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        currentPage = prefs.getInt("current", -1);
        vPager.setCurrentItem(currentPage);
    }
}