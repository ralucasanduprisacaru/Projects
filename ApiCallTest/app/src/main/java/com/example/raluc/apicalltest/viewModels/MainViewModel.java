package com.example.raluc.apicalltest.viewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.util.Log;

import com.example.raluc.apicalltest.data.remote.RemoteServiceHelper;
import com.example.raluc.apicalltest.data.repository.RepositoryImpl;
import com.example.raluc.apicalltest.models.Album;
import com.example.raluc.apicalltest.ui.MainActivity;
import com.example.raluc.apicalltest.ui.SearchResults;

import java.util.List;


public class MainViewModel extends ViewModel {

    private static String TAG = "MainViewModel";



    public MainViewModel() {
        Log.d(TAG, "inMainViewModel");
    }

}
