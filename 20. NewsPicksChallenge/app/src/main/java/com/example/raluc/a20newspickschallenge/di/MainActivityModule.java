package com.example.raluc.a20newspickschallenge.di;

import android.arch.lifecycle.MutableLiveData;

import com.example.raluc.a20newspickschallenge.ui.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @Provides
    MainPresenter providesMainPresenter(){
      return new MainPresenter();
    };

}
