package com.ralu.locationandviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "Second Activity";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //binding views
        textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        switch (intent.getAction()) {
            case "sendingValue":
                String value = intent.getStringExtra(Constants.KEY_1);
                Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
                textView.setText(value);
                break;

            case "sendingPerson":

                StringBuilder sb = new StringBuilder();
                Person person = (Person) intent.getSerializableExtra(Constants.KEY_2);
                sb.append(person.getName());
                sb.append(" ");
                sb.append(person.getGender());
                textView.setText(sb.toString());
                Log.d(TAG, "Person " + sb.toString());
                break;
        }


        Log.d(TAG, "onCreate: ");
    }


    protected void onStart() {

        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    protected void onResume() {

        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    protected void onPause() {

        super.onPause();
        Log.d(TAG, "onPause: ");
    }


    protected void onStop() {

        super.onStop();
        Log.d(TAG, "onStop: ");
    }


    protected void onDestroy() {

        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

}
