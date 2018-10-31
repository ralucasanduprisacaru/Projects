package com.example.raluc.a20newspickschallenge.di;

import com.example.raluc.a20newspickschallenge.ui.SecondActivity;

import dagger.Component;

@Component(modules = SecondActivityModule.class)
public interface SecondActivityComponent {
    void inject(SecondActivity secondActivity);
}
