package com.example.raluc.apicalltest.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.raluc.apicalltest.R;
import com.example.raluc.apicalltest.adapter.AlbumAdapter;
import com.example.raluc.apicalltest.models.Album;
import com.example.raluc.apicalltest.viewModels.SearchResultsViewModel;

import java.util.List;

public class SearchResults extends AppCompatActivity {

    private final String TAG = "SearchResults";
    private RecyclerView recycler;
    private AlbumAdapter adapter;
    private LiveData<Album> albumList;
    private SearchResultsViewModel viewModel;
    private String artist;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        Log.d(TAG, "onCreate: ");
        viewModel = ViewModelProviders.of(this).get(SearchResultsViewModel.class);
        recycler = findViewById(R.id.recycler);

        Intent intent = getIntent();
        artist = intent.getStringExtra("artist");
        Log.d(TAG, "artist name: " + artist);
        linearLayoutManager = new LinearLayoutManager(this);


        viewModel.getAlbums(artist).observe(this, new Observer<AlbumAdapter>() {
            @Override
            public void onChanged(@Nullable AlbumAdapter albumAdapter) {
                recycler.setLayoutManager(linearLayoutManager);
               recycler.setAdapter(new AlbumAdapter((List<Album>) albumList));
            }
        });

    }
}


