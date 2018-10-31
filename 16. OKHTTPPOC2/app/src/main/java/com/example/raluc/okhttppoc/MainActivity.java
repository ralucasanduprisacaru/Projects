package com.example.raluc.okhttppoc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raluc.okhttppoc.models.PostResponse;
import com.example.raluc.okhttppoc.models.WeatherData;
import com.google.gson.Gson;

import java.io.IOException;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;

public class MainActivity extends AppCompatActivity {
    private static final  String TAG = "MainActivity";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    public void addQueryParams(View view) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Gson gson = new Gson();
        // build the URL
        HttpUrl.Builder urlBuilder = HttpUrl
                .parse(Constants.URLS.WEATHER_BASE_URL + "data/2.5/forecast").newBuilder();
        urlBuilder.addQueryParameter("zip", Constants.MISC.ZIP);
        urlBuilder.addQueryParameter("appid", Constants.MISC.APPID);

        // build the request object
        Request request = new Request.Builder()
                .url(urlBuilder.build())
                .build();

        new Thread(()->{
            try {
                Response response = okHttpClient.newCall(request).execute();
                ResponseBody responseBody = response.body();
                WeatherData data = gson.fromJson(responseBody.string(), WeatherData.class);
                textView.setText(data.getCity().getCountry());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void sendPostWithFormBody(View view) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Gson gson = new Gson();

        RequestBody requestBody = new FormBody.Builder()
                .add("name", "jason")
                .add("age", "31")
                .build();

        Request request = new Request.Builder()
                .url(Constants.URLS.TEST_BASE_URL + "post")
                .post(requestBody)
                .build();

        Single.fromCallable(()->{
            Response response = okHttpClient.newCall(request).execute();
            ResponseBody responseBody = response.body();
            return responseBody.string();
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        .subscribe(json->{
            PostResponse postResponse = gson.fromJson(json, PostResponse.class);
            textView.setText(postResponse.getUrl());
            Log.d(TAG, "sendPostWithFormBody: " + json);
        }, Throwable::printStackTrace);

    }

    public void sendPostWithAuth(View view) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        HttpUrl.Builder builder = HttpUrl.parse(Constants.URLS.TEST_BASE_URL + "basic-auth/")
                .newBuilder();

        builder.addPathSegment("jason");
        builder.addPathSegment("gomez");
        Request request = new Request.Builder()
                .url(builder.build())
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                runOnUiThread(()->textView.setText(String.valueOf(response.code())));
            }
        });

    }

    public void sendPostWithJson(View view) {
        Gson gson = new Gson();
        Person person = new Person("Jason", "Dog", 25);
        String json = gson.toJson(person);
        OkHttpClient okHttpClient = new OkHttpClient();

        RequestBody requestBody = RequestBody
                .create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url(Constants.URLS.TEST_BASE_URL + "post")
                .post(requestBody)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse: " + response.body().string());
                runOnUiThread(()->{
                    Toast.makeText(MainActivity.this, String.valueOf(response.code()), Toast.LENGTH_LONG).show();
                });
            }
        });

    }
}
