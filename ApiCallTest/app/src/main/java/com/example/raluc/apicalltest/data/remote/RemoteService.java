package com.example.raluc.apicalltest.data.remote;

import com.example.raluc.apicalltest.models.Album;
import com.example.raluc.apicalltest.models.Artist;

import java.util.Map;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;


public interface RemoteService {


    @GET("/2.0")
    Single<Artist> getAlbums(
            @Query("method") String method,
            @Query("search") String search,
            @Query("artist") String artist,
            @Query("apiKey") String apiKey,
            @Query("format") String format
    );




}
