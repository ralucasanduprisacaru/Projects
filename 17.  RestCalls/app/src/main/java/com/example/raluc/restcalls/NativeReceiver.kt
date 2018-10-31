package com.example.raluc.restcalls

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.JsonReader
import android.util.Log
import android.widget.Toast
import org.json.JSONException
import org.json.JSONObject

class NativeReceiver : BroadcastReceiver () {

    private val TAG = "NativeReceiver"

    override fun onReceive(context: Context?, intent: Intent?) {

        Log.d(TAG, "onReceive: " + intent?.getIntExtra(Constants.KEY.CODE, 0) + "\n" + intent?.getStringExtra(Constants.KEY.MESSAGE))

        val response = intent?.getStringExtra(Constants.KEY.RESPONSE)

        try {

            val reader = JSONObject(response)
            val widget = reader.getJSONObject("widget")
            val text = widget.getJSONObject("text")
            val size = text.getString("style")

            Toast.makeText(context, size, Toast.LENGTH_LONG).show()

        }catch (e: JSONException){
            e.printStackTrace()
        }

    }
}