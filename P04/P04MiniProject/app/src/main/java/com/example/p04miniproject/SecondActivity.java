package com.example.p04miniproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);





        DBHelper db = new DBHelper(SecondActivity.this);

        ArrayList<Review> data = db.getTaskContent();

        db.close();
        ListView lv = findViewById(R.id.listView);

        CustomAdapter ca = new CustomAdapter(SecondActivity.this, R.layout.row,data);
        lv.setAdapter(ca);
    }
}
