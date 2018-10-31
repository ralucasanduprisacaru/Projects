package com.example.raluc.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyStaticReceiver extends BroadcastReceiver {

    private static final String TAG = "StaticReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        switch(intent.getAction()){
            case "myAction":
                Log.d(TAG, "static receiver action");
                Toast.makeText(context, "onReceive: myAction", Toast.LENGTH_LONG ).show();
                break;

            case "myAction2":
                Toast.makeText(context, "Second activity .. same thing", Toast.LENGTH_LONG).show();
                break;

            case Intent.ACTION_BOOT_COMPLETED:
                Toast.makeText(context, "Bood Completed", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
