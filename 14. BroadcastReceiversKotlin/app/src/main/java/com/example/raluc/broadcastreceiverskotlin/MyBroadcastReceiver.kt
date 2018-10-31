package com.example.raluc.broadcastreceiverskotlin

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.PersistableBundle
import android.support.annotation.RequiresApi
import android.util.Log

class MyBroadcastReceiver : BroadcastReceiver () {
    private val TAG = "MyBroadcastReceiver"

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onReceive(context: Context?, intent: Intent?) {

        Log.d(TAG, " onReceive: ")
        val persistableBundle = PersistableBundle()
        persistableBundle.putString("data", intent?.getStringExtra("data"))
        val componentName = ComponentName(context, MyJobService::class.java)
        val jobInfo = JobInfo.Builder(0, componentName)
        jobInfo.setOverrideDeadline(3000)
        jobInfo.setExtras(persistableBundle)

        val jobScheduler = context?.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        jobScheduler.schedule(jobInfo.build())
    }


}