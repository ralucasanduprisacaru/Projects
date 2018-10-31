package com.example.raluc.broadcastreceivers;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MyDynamicReceiver myDynamicReceiver = new MyDynamicReceiver();
    private IntentFilter intentFilter;
    private static final String TAG = "Main";

    // register the receiver in onstart and unregister in onstop


    @Override
    protected void onStart() {
            super.onStart();
            intentFilter = new IntentFilter();
            intentFilter.addAction("doSomething");
            intentFilter.addAction("doSomethingElsse");
            registerReceiver(myDynamicReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();

        unregisterReceiver(myDynamicReceiver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendBroadcasts(View view) {

        switch(view.getId()){
            case R.id.btnDynamicBroadcast:
                Intent dynamicIntent = new Intent();
                dynamicIntent.setAction("doSomething");
                sendBroadcast(dynamicIntent);

            case R.id.btnDynamicBroadcast2:
                Intent stilldynamicIntent = new Intent();
                stilldynamicIntent.setAction("doSomethingElsse");
                sendBroadcast(stilldynamicIntent);

            case R.id.btnStaticBroadcast:
                Intent staticIntent = new Intent();
                staticIntent.setAction("myAction");
                staticIntent.setComponent(
                        new ComponentName("com.example.raluc.broadcastreceivers", "com.example.raluc.broadcastreceivers.MyStaticReceiver")
                );

                sendBroadcast(staticIntent);
                break;

            case R.id.btnStaticBroadcast2:
                Intent staticIntent2 = new Intent();
                staticIntent2.setAction("myAction2");
                staticIntent2.setComponent(
                        new ComponentName("com.example.raluc.broadcastreceivers", "com.example.raluc.broadcastreceivers.MyStaticReceiver")
                );

                sendBroadcast(staticIntent2);
                break;

            case R.id.btnStaticBroadcastBootCompleted:
                Intent staticboot = new Intent();
                staticboot.setAction(Intent.ACTION_BOOT_COMPLETED);
                sendBroadcast(staticboot);
                break;


        }


    }
}
