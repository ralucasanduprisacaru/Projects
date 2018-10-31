package com.example.raluc.a20newspickschallenge.di;

import com.example.raluc.a20newspickschallenge.ui.SecondPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class SecondActivityModule {

    @Provides
    SecondPresenter secondPresenter(){
        return new SecondPresenter();
    }

}
