package com.example.raluc.apicalltest.data.repository;

import android.arch.lifecycle.MutableLiveData;

import com.example.raluc.apicalltest.Constants;
import com.example.raluc.apicalltest.data.remote.RemoteServiceHelper;
import com.example.raluc.apicalltest.models.Album;
import com.example.raluc.apicalltest.models.Albummatches;
import com.example.raluc.apicalltest.models.Artist;
import com.example.raluc.apicalltest.models.Results;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RepositoryImpl implements Repository {

    private RemoteServiceHelper remoteServiceHelper;
    private MutableLiveData <List<Album>> getAlbumLiveData;


    public RepositoryImpl(RemoteServiceHelper remoteServiceHelper, MutableLiveData<List<Album>> getAlbumLiveData) {
        this.remoteServiceHelper = remoteServiceHelper;
        this.getAlbumLiveData = getAlbumLiveData;
    }

    @Override
    public MutableLiveData<List<Album>> getAlbums(String artist) {

         remoteServiceHelper.getAlbums(Constants.METHOD, Constants.SEARCH, artist, Constants.API_KEY, Constants.FORMAT )
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .map(Artist::getResults)
                .map(Results::getAlbummatches)
                .map(Albummatches::getAlbum)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(albums -> getAlbumLiveData.setValue(albums), Throwable::printStackTrace);

                 return getAlbumLiveData;

    }
}
