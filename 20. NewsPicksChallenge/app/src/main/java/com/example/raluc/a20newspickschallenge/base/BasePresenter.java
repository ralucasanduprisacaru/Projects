package com.example.raluc.a20newspickschallenge.base;


import android.widget.TextView;

public interface BasePresenter <V extends BaseView>{

    void attachView (V view);

    void removeView(String s);


}
