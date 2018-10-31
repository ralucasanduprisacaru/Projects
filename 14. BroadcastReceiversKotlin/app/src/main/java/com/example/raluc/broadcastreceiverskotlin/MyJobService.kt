package com.example.raluc.broadcastreceiverskotlin

import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)

class MyJobService: JobService() {

    private val TAG= "MYHOBSERVICE"

    override fun onStartJob(jobParameters: JobParameters?): Boolean {
        Log.d(TAG, "onStartJob: ")
        val bundle = jobParameters?.extras
        val message = bundle?.getString("data")

        val intent = Intent(applicationContext, MyIntentService::class.java)
        intent.putExtra("data", message)
        applicationContext.startService(intent)
        return false

    }

    override fun onStopJob(params: JobParameters?): Boolean {
        return false
    }


}