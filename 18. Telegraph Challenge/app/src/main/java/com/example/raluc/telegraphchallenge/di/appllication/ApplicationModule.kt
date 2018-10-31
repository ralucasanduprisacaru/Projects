package com.example.raluc.telegraphchallenge.di.appllication

import com.example.raluc.telegraphchallenge.data.remote.RemoteServiceHelper
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {
    @Provides
    @ApplicationScope
    fun providesRemoteServiceHelper() = RemoteServiceHelper()

}