package com.example.raluc.myapplication.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


public class MainActivityPresenter implements MainContract.Presenter {

    private static final String TAG = "MainPresenterTAG";
    MainContract.View view;
    Context context;


    @Override
    public void savePerson(String person) {
        Log.d(TAG, "savePerson: " + person);
        SharedPreferences sharedPreferences = context.getSharedPreferences("myPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("person", person);
        boolean isSaved = editor.commit();

        view.isPersonSaved(isSaved);
    }

    @Override
    public void getPerson() {
        String person;
        SharedPreferences sharedPreferences = context.getSharedPreferences("myPref", Context.MODE_PRIVATE);
        person = sharedPreferences.getString("person", "default person");
        view.sendPerson(person);
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;

    }

    @Override
    public void removeView(String s) {
        view = null;
    }
}
