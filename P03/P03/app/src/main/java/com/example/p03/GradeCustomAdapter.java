package com.example.p03;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GradeCustomAdapter extends ArrayAdapter {


    Context parent_context;
    int layout_id;
    ArrayList<Grade> shopList;

    public GradeCustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList objects) {
        super(context, resource,  objects);
        parent_context = context;
        layout_id = resource;
        shopList = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id,parent,false);

        TextView tVname = rowView.findViewById(R.id.tVGrade);
        TextView tVIcon = rowView.findViewById(R.id.tVWeek);

        Grade currentShop = shopList.get(position);

        tVname.setText(currentShop.getGrade()+"");
        tVIcon.setText("WEEK: " + (position+1));

        return rowView;
    }

}
