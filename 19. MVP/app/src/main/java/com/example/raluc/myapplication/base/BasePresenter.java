package com.example.raluc.myapplication.base;

public interface BasePresenter <V extends BaseView> {

    void attachView(V view);

    void removeView(String s);
}

