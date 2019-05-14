package com.example.p04quiz_17010596;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnNext;
    EditText etBrand, etLitre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("MainActivity - Insert");
        btnInsert = findViewById(R.id.btnInsert);
        btnNext = findViewById(R.id.btnNext);
        etBrand = findViewById(R.id.etBrand);
        etLitre = findViewById(R.id.etLitre);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String brand = etBrand.getText().toString();
                double litre = Double.parseDouble(etLitre.getText().toString());

                DBHelper db = new DBHelper(MainActivity.this);

                db.insertTask(brand,litre);
                db.close();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                ArrayList<Car> data = db.getTaskContent();
                db.close();

                TextView tv = findViewById(R.id.textView);
                String msg = "";
                for(Car i : data){
                    msg+= ("id: "+ i.getId() + " brand: " + i.getBrand() + " litre:" + i.getLitre()+ "\n");
                }



                tv.setText(msg);

            }
        });
    }
}
