package com.example.p04miniproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnNext;
    EditText edDesc;
    RadioGroup rg;
    RadioButton selectedRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("MainActivity - Insert");
        btnInsert = findViewById(R.id.btnInsert);
        btnNext = findViewById(R.id.btnNext);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rg = findViewById(R.id.radioGroupStar);
                int selected = rg.getCheckedRadioButtonId();

                selectedRadio = findViewById(selected);
                edDesc = findViewById(R.id.edDesc);
                int star = 0;
                if(selectedRadio != null) {
                    star = Integer.parseInt(selectedRadio.getText().toString());
                }
                String desc = edDesc.getText().toString();




                if(!desc.equalsIgnoreCase("") && star != 0) {
                    DBHelper db = new DBHelper(MainActivity.this);
                    boolean repeating = false;
                    ArrayList<String> checkList  = db.getTask();

                    for(String i : checkList){
                        if(i.equalsIgnoreCase(desc)){
                            repeating = true;
                        }
                    }




                    if(!repeating) {
                        db.insertTask(desc, star);
                        db.close();

                        Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "Repeating Content", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Fill Up all the fields", Toast.LENGTH_SHORT).show();
                }


            }


        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });







    }
}
