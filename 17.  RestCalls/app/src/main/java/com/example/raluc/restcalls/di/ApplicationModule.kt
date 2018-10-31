package com.example.raluc.restcalls.di

import com.example.raluc.restcalls.NativeReceiver
import com.example.raluc.restcalls.remote.RemoteServiceHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun getRemoteServiceHelper(): RemoteServiceHelper {
        return RemoteServiceHelper()
    }

    @Provides
    fun providesNativeReceiver(): NativeReceiver {
        return NativeReceiver()
    }
}