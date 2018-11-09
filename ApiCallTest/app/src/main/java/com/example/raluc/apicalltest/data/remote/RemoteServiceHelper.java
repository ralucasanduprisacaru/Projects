package com.example.raluc.apicalltest.data.remote;

import com.example.raluc.apicalltest.Constants;
import com.example.raluc.apicalltest.models.Album;
import com.example.raluc.apicalltest.models.Artist;

import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteServiceHelper implements RemoteService {


    @Override
    public Single<Artist> getAlbums(String method, String search, String artist, String apiKey, String format) {
        Retrofit retrofit = getRetrofit();
        RemoteService service = retrofit.create(RemoteService.class);
        return service.getAlbums(method, search, artist, apiKey, format);
    }


    private Retrofit getRetrofit() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();


        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
