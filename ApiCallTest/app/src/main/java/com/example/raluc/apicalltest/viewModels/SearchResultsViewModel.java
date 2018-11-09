package com.example.raluc.apicalltest.viewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.example.raluc.apicalltest.adapter.AlbumAdapter;
import com.example.raluc.apicalltest.data.remote.RemoteServiceHelper;
import com.example.raluc.apicalltest.data.repository.RepositoryImpl;
import com.example.raluc.apicalltest.models.Album;

import java.util.List;

public class SearchResultsViewModel extends ViewModel {
    private RepositoryImpl repository;
    private RemoteServiceHelper remoteServiceHelper;
    private MutableLiveData<List<Album>> getAlbumLiveData;



    public SearchResultsViewModel() {

        remoteServiceHelper = new RemoteServiceHelper();
        getAlbumLiveData = new MutableLiveData<>();
        repository = new RepositoryImpl(remoteServiceHelper, getAlbumLiveData);

    }



    public LiveData<AlbumAdapter> getAlbums(String artist){

        MutableLiveData<List<Album>> albumList = repository.getAlbums(artist);
        LiveData<AlbumAdapter> adapter = Transformations.map(albumList,input -> {
             return new AlbumAdapter((List<Album>) albumList);
        } );

        return adapter;
    }







}
