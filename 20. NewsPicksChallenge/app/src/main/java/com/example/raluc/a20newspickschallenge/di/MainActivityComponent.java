package com.example.raluc.a20newspickschallenge.di;

import com.example.raluc.a20newspickschallenge.ui.MainActivity;

import dagger.Component;

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
