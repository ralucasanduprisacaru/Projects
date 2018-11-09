package com.example.raluc.challenge

import android.app.Application
import com.example.raluc.challenge.di.application.ApplicationComponent
import com.example.raluc.challenge.di.application.ApplicationModule
import com.example.raluc.challenge.di.application.DaggerApplicationComponent

class AppController : Application() {

    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}