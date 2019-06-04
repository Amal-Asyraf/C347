package com.example.p07_smsretriever;


import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFirst extends Fragment {

    EditText et;
    TextView tvNum;
    public FragmentFirst() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);
        Button btnNum = view.findViewById(R.id.btnRetrieveByNum);
        tvNum = view.findViewById(R.id.tvNum);
        et = view.findViewById(R.id.etNum);

        btnNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        Uri uri = Uri.parse("content://sms");


        String num = et.getText().toString();
        String[] reqCols = new String[]{"date","address","body","type"};

        ContentResolver cr = getActivity().getContentResolver();

        Cursor cursor = cr.query(uri, reqCols, null,null,null);
        String smsBody = "";

        if(cursor.moveToFirst()){
            do{
                long dataInMillis = cursor.getLong(0);

                String date = (String) DateFormat.format("dd MMM yyyy h:mm:ss aa", dataInMillis);
                String address = cursor.getString(1);
                String body = cursor.getString(2);
                String type = cursor.getString(3);



                if(!address.equalsIgnoreCase(num)) {
                    smsBody = "";
                    tvNum.setText(smsBody);
                   return;
                }else{
                    if(type.equalsIgnoreCase("1")) {
                        type = "Inbox: ";
                    }else{
                        type = "Sent: ";
                    }
                }
                smsBody += type +  " " + address + "\n at " + date + "\n\"" + body + "\"\n\n";
            }while (cursor.moveToNext());
        }
        tvNum.setText(smsBody);

            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}
