package com.example.raluc.telegraphchallenge.data.repository

import android.arch.lifecycle.MutableLiveData
import com.example.raluc.telegraphchallenge.models.Response

interface Repository {

    fun getPopularMovies(): MutableLiveData<Response>
}