package com.example.p03;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeFragement extends Fragment {
    Module module1 = new Module("C347", "Android Programming II");
    Module module2 = new Module("C349", "Ipad Programming");
    ArrayList<Module> alModule = new ArrayList();
    ModuleCustomAdapter mca;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment

        ListView listView = rootView.findViewById(R.id.lVmodule);

        alModule.add(module1);
        alModule.add(module2);

        mca = new ModuleCustomAdapter(getActivity(), R.layout.module_row, alModule);
        listView.setAdapter(mca);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), GradeActivity.class);
                Module curModule = alModule.get(position);

                i.putExtra("code", curModule.getCode());

                startActivity(i);

            }
        });

        return rootView;
    }
}
