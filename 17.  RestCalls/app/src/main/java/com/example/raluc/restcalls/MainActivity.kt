package com.example.raluc.restcalls

import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentHostCallback
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.raluc.restcalls.di.DaggerApplicationComponent
import com.example.raluc.restcalls.model.WeatherData
import com.example.raluc.restcalls.remote.RemoteServiceHelper
import com.google.gson.Gson
import okhttp3.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var remoteServiceHelper: RemoteServiceHelper

    @Inject
    lateinit var myIntentService: MyIntentService

    private val TAG="MainActivity"
    private lateinit var nativeReceiver: NativeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependencies()

        nativeReceiver = NativeReceiver()
    }

    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter()
        intentFilter.addAction(Constants.NATIVE_RECEIVER_ACTION)
        registerReceiver(nativeReceiver, intentFilter);
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(nativeReceiver)
    }



    fun makeCall(view: View) {
        val okHttpClient = OkHttpClient()
        when (view.id) {
            R.id.btnNtaiveHttp -> {
                val intent = Intent(view.context, MyIntentService::class.java)
                intent.putExtra(Constants.KEY.URL, Constants.INTENT_SERVICE_BASE_URL)
                startService(intent)
            }

            R.id.btnOkHttpSymc -> {
                val syncRequest = Request.Builder().url(Constants.PERSON_BASE_URL).build()

                Thread {
                    try {
                        val response = okHttpClient.newCall(syncRequest).execute()
                        val jsonObject = JSONObject (response.body()?.string())

                        runOnUiThread {
                            Toast.makeText(this@MainActivity , jsonObject.getString("name"), Toast.LENGTH_LONG).show()
                        }

                    }catch (e: IOException){
                        e.printStackTrace()
                    }catch (e: JSONException){
                        e.printStackTrace()
                    }
                }.start()
            }

            R.id.btnOkHttpASymc -> {
                val asyncRequest = Request.Builder()
                    .url(Constants.PERSON_BASE_URL)
                    .build()
                okHttpClient.newCall(asyncRequest).enqueue(object: Callback {
                    override fun onFailure(call: Call, e: IOException) {
                       e.printStackTrace()
                    }

                    override fun onResponse(call: Call, response: Response) {
                       runOnUiThread {
                           val gson = Gson()
                           val personJson = response.body()?.string()
                           val person = gson.fromJson(personJson, Person::class.java)
                           Log.d(TAG,"onResponse" + person.toString())
                           Toast.makeText(this@MainActivity, response.code().toString(), Toast.LENGTH_LONG).show()

                       }
                    }

                })
            }

            R.id.btnRetrofitSync -> {
                val gson = Gson()
                Thread {
                    val response = remoteServiceHelper.getWeatherData().execute()
                    val json = response.body()?.string()
                    val data = gson.fromJson<WeatherData>(json, WeatherData::class.java)
                    Log.d(TAG, "City name: " + data.city.name + " " + "City Population" + data.city.population)
                }.start()


            }

            R.id.btnRetrofitAsync ->{
                val gson = Gson()
                remoteServiceHelper.getWeatherData().enqueue(object : retrofit2.Callback<ResponseBody> {
                    override fun onFailure(call: retrofit2.Call<ResponseBody>, t: Throwable) {
                        t.printStackTrace()
                    }

                    override fun onResponse(
                        call: retrofit2.Call<ResponseBody>,
                        response: retrofit2.Response<ResponseBody>
                    ) {
                      val json = response.body()?.string()
                        val data = gson.fromJson<WeatherData>(json, WeatherData::class.java)
                        Log.d(TAG, "City name: " + data.city.name + " City population: " + data.city.population)
                    }

                })
            }
        }

    }

    private fun injectDependencies(){
        DaggerApplicationComponent.create().inject(this)
    }
}
