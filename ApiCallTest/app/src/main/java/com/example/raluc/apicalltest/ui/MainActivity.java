package com.example.raluc.apicalltest.ui;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.raluc.apicalltest.R;
import com.example.raluc.apicalltest.viewModels.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MAinActivity";
    private MainViewModel mainViewModel;
    private Button button;
    private EditText et_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");


        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        et_name = findViewById(R.id.et_artist);


    }

    public void searchArtist(View view) {

        Intent intent = new Intent(this, SearchResults.class);
        intent.putExtra("artist", et_name.getText().toString());
        startActivity(intent);
    }
}
