package com.example.raluc.mybroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class BrowserReceiver: BroadcastReceiver() {

    private val TAG = "BroadcastReceiver"
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(TAG, "ONRECEIVE: ")
        val uri = intent?.data
        val newIntent = Intent(Intent.ACTION_VIEW, uri)
        newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context?.startActivity(newIntent)
    }
}