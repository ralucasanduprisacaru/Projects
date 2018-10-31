package com.example.raluc.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyDynamicReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        switch (intent.getAction()) {
            case "doSomething":
                Toast.makeText(context, "I am dynamic", Toast.LENGTH_SHORT).show();
                break;

            case "doSomethingElsse":
                Toast.makeText(context, "Still dynamic", Toast.LENGTH_LONG).show();
                break;



        }

    }
}
