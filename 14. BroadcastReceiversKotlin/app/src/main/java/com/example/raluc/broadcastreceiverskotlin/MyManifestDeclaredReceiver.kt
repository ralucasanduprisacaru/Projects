package com.example.raluc.broadcastreceiverskotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyManifestDeclaredReceiver: BroadcastReceiver() {
    private val TAG = "ManifestDeclaredReceiv"

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(TAG, "onReceive: ")

        val message = intent?.getStringExtra("data")
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()

    }
}