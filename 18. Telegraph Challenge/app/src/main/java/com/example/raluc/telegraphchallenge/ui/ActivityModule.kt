package com.example.raluc.telegraphchallenge.ui

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import com.example.raluc.telegraphchallenge.R
import dagger.Module
import dagger.Provides

@Module
class ActivityModule (val appCompatActivity: AppCompatActivity) {

    @Provides
@ActivityScope
fun getMainViewModel(mainViewModelFactory: MainViewModelFactory) = ViewModelProviders.of(appCompatActivity, mainViewModel(Factory).get(MainViewModel::class.java))

 @Provides
@ActivityScope
fun getMainActivityBinding(): ActivityBinding = DataBindingUtil.setContentView(appCompatActivity, R.layout.activity_main)

}