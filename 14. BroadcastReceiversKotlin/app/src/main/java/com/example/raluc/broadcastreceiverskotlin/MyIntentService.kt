package com.example.raluc.broadcastreceiverskotlin

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService :IntentService ("IntentService"){

    private val TAG = "IntentService"

    override fun onHandleIntent(intent: Intent?) {
        Log.d(TAG, "onHandleIntent")
        val newIntent = Intent()
        val message = intent?.getStringExtra("data")
        newIntent.putExtra("data", message)
        newIntent.action = Constants.MY_SERVICEBROADCAST
        newIntent.setPackage("com.example.raluc.broadcastreceiverskotlin")
        sendBroadcast(newIntent)

    }

}
