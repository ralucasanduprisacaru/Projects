package com.example.raluc.broadcastreceiverskotlin

import android.content.ComponentName
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "Main"

    lateinit var myBroadcastReceiver: MyBroadcastReceiver


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myBroadcastReceiver = MyBroadcastReceiver()
        setUpListners()


    }

    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter()
        intentFilter.addAction(Constants.MY_BROADCAST)
        registerReceiver(myBroadcastReceiver, intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(myBroadcastReceiver)
    }

    private fun setUpListners(){
        btnSendBroadcast.setOnClickListener{
            val intent = Intent()
            intent.action = Constants.MY_BROADCAST
            intent.putExtra("data", "this is my messsage")
            sendBroadcast(intent)
        }

        btnSendActionViewBroadcast.setOnClickListener{
            val intent = Intent()
            intent.action = "BROWSER_EVENT"
            intent.component = ComponentName("com.example.raluc.mybroadcastreceiver",
                "com.example.raluc.mybroadcastreceiver.BrowserReceiver")
            intent.data = Uri.parse("https://developer.android.com")
            sendBroadcast(intent)
        }

        btnSendLocalActionViewBroadcast.setOnClickListener{
            val intent = Intent()
            intent.action = "BROWSER_EVENT"
            intent.component = ComponentName("com.example.raluc.mybroadcastreceiver",
                "com.example.raluc.mybroadcastreceiver.BrowserReceiver")
            intent.data = Uri.parse("https://developer.android.com")
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
        }
    }
}
