package com.example.raluc.a20newspickschallenge.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainPresenter implements MainContract.Presenter {
    private  final String TAG = "Presenter";
    MainContract.View view;
    Context context;


    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView(String s) {
        this.view = null;
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public boolean validateFields(String field) {
        Log.d(TAG, "onValidateFields");
        boolean validated = false;

        if (field.isEmpty()) {
            validated = false;
            view.toastMessage("This " + field + " cannot be empty");
        } else {
            validated = true;
        }
        return validated;
    }

    @Override
    public void validateButton(boolean email, boolean password) {
        if (email&&password){
            view.disableButton(false);
            view.changeButtonColorStrong();
        }else {
            view.disableButton(true);
            view.changeButtonColorWeak();
        }
    }

    @Override
    public void onButtonClicked(boolean emailChanged, boolean passwordChanged) {
            if (emailChanged&&passwordChanged){
                view.toastMessage("Success!");
                view.startSecondActivity();
            }else {
                view.showErrorAlert();
            }
    }


}








