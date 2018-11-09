package com.example.raluc.apicalltest.data.repository;

import android.arch.lifecycle.MutableLiveData;

import com.example.raluc.apicalltest.models.Album;
import com.example.raluc.apicalltest.models.Artist;

import java.util.List;

public interface Repository {

    public MutableLiveData<List<Album>> getAlbums(String artist);
}
