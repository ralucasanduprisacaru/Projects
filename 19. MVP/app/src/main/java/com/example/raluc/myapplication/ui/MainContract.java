package com.example.raluc.myapplication.ui;

import android.content.Context;

import com.example.raluc.myapplication.base.BasePresenter;
import com.example.raluc.myapplication.base.BaseView;

public interface MainContract {

    interface View extends BaseView {
        void isPersonSaved (boolean isSaved);

        void sendPerson(String person);
    }

    interface Presenter extends BasePresenter <View>{

        void savePerson(String person);
        void getPerson();
        void setContext(Context context);
    }
}
