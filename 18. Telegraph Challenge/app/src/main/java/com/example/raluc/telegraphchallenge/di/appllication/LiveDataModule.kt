package com.example.raluc.telegraphchallenge.di.appllication

import android.arch.lifecycle.MutableLiveData
import com.example.raluc.telegraphchallenge.models.Response
import dagger.Module
import dagger.Provides

@Module
class LiveDataModule {

    @Provides
    fun providesResponseMutableLiveData(): MutableLiveData<Response> = MutableLiveData()
}