package com.example.raluc.telegraphchallenge.di.appllication

import com.example.raluc.telegraphchallenge.data.repository.RepositoryImpl
import dagger.Component

interface ApplicationComponent {

    @ApplicationScope
    @Component(modules = [ApplicationModule::class, LiveDataModule::class])
    interface ApplicationComponent {
        fun getRepositoryImpl(): RepositoryImpl
    }
}