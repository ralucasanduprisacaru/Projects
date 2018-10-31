package com.ralu.webviewssqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "Second Activity";
    private TextView name, number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate");

        //binding data

        name = findViewById(R.id.tvName);
        number = findViewById(R.id.tvNumber);
    }

    @Override
    protected void onResume (){
        super.onResume();

        ArrayList<MyContact> contacts;

        String sbNames = "";
        String sbNumbers = "";

        contacts = getIntent().getParcelableArrayListExtra("contactsList");

        for (MyContact contact: contacts){
            sbNames = sbNames + contact.getName() + "/n";
            sbNumbers = sbNumbers + contact.getNumber() + " /n";
        }

        name.setText(sbNames);
        number.setText(sbNumbers);


    }
}
