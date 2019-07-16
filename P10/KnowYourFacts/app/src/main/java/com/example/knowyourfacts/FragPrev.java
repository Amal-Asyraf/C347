package com.example.knowyourfacts;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jsibbold.zoomage.ZoomageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragPrev extends Fragment {
    Button btnChangeColor;
    ZoomageView iv;


    public FragPrev() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_frag_curr, container,false);
        btnChangeColor = view.findViewById(R.id.btnChangeColor);
        iv = view.findViewById(R.id.Iv);
        TextView tv = view.findViewById(R.id.textView);
        tv.setText(R.string.fact2);
        String imageUrl = "https://thecoliner.github.io/Images/Ncc.jpg";
        Picasso.with(getContext()).load(imageUrl).into(iv);

        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int n = rand.nextInt(3);
                ArrayList<Integer> colors = new ArrayList<>();
                colors.add(Color.BLUE);
                colors.add(Color.GRAY);
                colors.add(Color.GREEN);

                view.setBackgroundColor(colors.get(n));

            }
        });
        return view;
    }

}
