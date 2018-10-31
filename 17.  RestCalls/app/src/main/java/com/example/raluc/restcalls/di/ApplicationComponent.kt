package com.example.raluc.restcalls.di

import com.example.raluc.restcalls.MainActivity
import com.example.raluc.restcalls.MyIntentService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)

    fun getMyIntentService(): MyIntentService
}