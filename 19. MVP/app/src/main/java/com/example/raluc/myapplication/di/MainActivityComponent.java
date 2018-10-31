package com.example.raluc.myapplication.di;

import com.example.raluc.myapplication.ui.MainActivity;


import dagger.Component;

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);
}
