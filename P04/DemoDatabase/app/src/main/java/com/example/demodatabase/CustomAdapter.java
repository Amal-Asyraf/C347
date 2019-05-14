package com.example.demodatabase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Task> taskList;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList objects) {
        super(context, resource,  objects);
        parent_context = context;
        layout_id = resource;
        taskList = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id,parent,false);

        TextView tVtask = rowView.findViewById(R.id.tVtask);
        TextView tVdate = rowView.findViewById(R.id.tVdate);
        TextView tVid = rowView.findViewById(R.id.tVid);

        Task currentTask = taskList.get(position);

        tVid.setText(currentTask.getId()+"");
        tVtask.setText(currentTask.getDescription());
        tVdate.setText(currentTask.getDate());

        return rowView;
    }




}
