package com.ralu.webviewssqlite;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main Activity";
    private WebView webView;
    private EditText etName, etNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //binding views

        webView = findViewById(R.id.webView);
        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        WebViewClient webViewClient = new WebViewClient();
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(webViewClient);

        webView.loadUrl("https://developer.android.com");
    }

    public void doSomething(View view){

        switch (view.getId()){
            case R.id.btnSaveContact:
                saveContact(view);
                break;
            case R.id.btnDisplayContact:
                displayContact(view);
                break;
        }

    }

    public void saveContact(View view) {

        MyContact contact = new MyContact(etName.getText().toString(), etNumber.getText().toString());
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        databaseHelper.saveNewContact(contact);
    }

    public void  displayContact(View view) {

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        List<MyContact> contacts = databaseHelper.getContacts();

        for (MyContact contact : contacts){
            Log.d(TAG, "displayContact: " + contact.getName() + " " + contact.getNumber());

        }

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putParcelableArrayListExtra("contactList", (ArrayList<? extends Parcelable>) contacts);
        startActivity(intent);


    }
}
