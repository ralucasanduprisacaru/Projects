package com.example.raluc.restcalls

import android.app.IntentService
import android.content.Intent
import java.io.BufferedInputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.*
import javax.inject.Inject


class MyIntentService @Inject constructor(nativeReceiver:NativeReceiver): IntentService("IntentService") {

    private val TAG = "MyIntentService"

    override fun onHandleIntent(intent: Intent?) {
        val url = intent?.getStringExtra(Constants.KEY.URL)
        val newIntent = Intent()
        lateinit var scanner: Scanner

        try {
            val connectionUrl = URL(url)
            val httpUrlConnection = connectionUrl.openConnection() as HttpURLConnection
            httpUrlConnection.connect()
            val inputStream = BufferedInputStream(httpUrlConnection.inputStream)
            scanner = Scanner(inputStream)
            val sb = StringBuilder()
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine())
            }
            val statusCode = httpUrlConnection.responseCode
            val statusMessage = httpUrlConnection.responseMessage
            newIntent.apply {
                action = Constants.NATIVE_RECEIVER_ACTION
                putExtra(Constants.KEY.CODE, statusCode)
                putExtra(Constants.KEY.MESSAGE, statusMessage)
                putExtra(Constants.KEY.RESPONSE, sb.toString())
            }
            sendBroadcast(newIntent)
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            scanner.close()
        }
    }
}