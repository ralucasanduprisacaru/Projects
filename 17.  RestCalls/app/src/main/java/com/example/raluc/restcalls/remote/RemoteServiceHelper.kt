package com.example.raluc.restcalls.remote

import com.example.raluc.restcalls.Constants

import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit

class RemoteServiceHelper {

    private val ZIP = "94040"
    private val APPID = "b1b15e88fa797225412429c1c50c122a1"
    var okHttpClient: OkHttpClient

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    fun getWeatherData(): Call<ResponseBody> {
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Constants.WEATHER_BASE_URL)
            .build()


        val service = retrofit.create(RemoteService::class.java)
        return service.getWeatherData(ZIP, APPID)


    }

}