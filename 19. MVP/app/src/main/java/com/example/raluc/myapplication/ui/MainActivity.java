package com.example.raluc.myapplication.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.raluc.myapplication.R;
import com.example.raluc.myapplication.di.DaggerMainActivityComponent;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity implements MainContract.View {

    public static final String TAG = "MainActivity";

    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // inject the presenter
        DaggerMainActivityComponent.create().inject(this);

        // attach view to the presenter and set a context
        presenter.attachView(this);
        presenter.setContext(this);
    }

    public void doMagic(View view) {
        presenter.savePerson("John Doe");
        presenter.getPerson();

    }

    // implemented from the MainContract

    @Override
    public void isPersonSaved(boolean isSaved) {
        Log.d(TAG, "isPersonSaved" + isSaved);
    }

    @Override
    public void sendPerson(String person) {
        Log.d(TAG, "sendPerson" + person);

    }

    @Override
    public void showError(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

}
