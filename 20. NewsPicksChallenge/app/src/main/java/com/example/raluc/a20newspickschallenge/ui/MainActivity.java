package com.example.raluc.a20newspickschallenge.ui;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.raluc.a20newspickschallenge.R;
import com.example.raluc.a20newspickschallenge.di.DaggerMainActivityComponent;

import javax.inject.Inject;

import static android.text.InputType.TYPE_CLASS_TEXT;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    public static final String TAG = "Main";
    private EditText email, password;
    private Button btnLogin;
    boolean emailChanged;
    boolean passwordChanged;
    private String emailString;
    private String passwordString;


    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DaggerMainActivityComponent.create().inject(this);
        presenter.attachView(this);
        presenter.setContext(this);

        bindData();

        //disable button
        changeButtonColorWeak();
        disableButton(true);

       email.addTextChangedListener(getEmailWatcher());
       password.addTextChangedListener(getPasswordWatcher());

    }


    // TEXT WATCHERS
        @Override
        public TextWatcher getEmailWatcher(){
        TextWatcher emailWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                emailChanged = presenter.validateFields(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                emailChanged = presenter.validateFields(s.toString());
            }
        };
        return emailWatcher;
       }

    @Override
    public TextWatcher getPasswordWatcher(){
        TextWatcher passwordWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                passwordChanged = presenter.validateFields(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                passwordChanged = presenter.validateFields(s.toString());
                presenter.validateButton(emailChanged, passwordChanged);
            }
        };
        return passwordWatcher;
    }

    public void btnClicked(View view) {

        String emailString = email.getText().toString();
        String passString = password.getText().toString();
        Log.d(TAG, "button clicked" + emailString + " " + passString);

        presenter.onButtonClicked(emailChanged, passwordChanged);

    }

    @Override
    public void startSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    public void showErrorAlert() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        //alertBuilder.setPositiveButton("OK", DialogInterface.OnClickListener);
    }

    // binding data

    private void bindData() {
        btnLogin = findViewById(R.id.btnLogin);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        emailChanged = false;
        passwordChanged = false;
          emailString = email.getText().toString();
          passwordString = password.getText().toString();
    }

    // util functions

    @Override
    public void disableButton(boolean enable) {
        btnLogin.setEnabled(!enable);
    }
    @Override
    public void showError(String s) {
        Toast.makeText(this, "Ups, something went wrong", Toast.LENGTH_LONG).show();
    }
    @Override
    public void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
    @Override
    public void changeButtonColorWeak() {
        btnLogin.setBackgroundColor(getResources().getColor(R.color.weak));
    }

    @Override
    public void changeButtonColorStrong() {
        btnLogin.setBackgroundColor(getResources().getColor(R.color.strong));
    }




}
