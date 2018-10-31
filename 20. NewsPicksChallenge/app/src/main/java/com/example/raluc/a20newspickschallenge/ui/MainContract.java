package com.example.raluc.a20newspickschallenge.ui;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.TextView;

import com.example.raluc.a20newspickschallenge.base.BasePresenter;
import com.example.raluc.a20newspickschallenge.base.BaseView;

public interface MainContract {

    interface View extends BaseView{
        void disableButton(boolean enable);
        void changeButtonColorWeak();
        void changeButtonColorStrong();
        void startSecondActivity();
        void showErrorAlert();
        void toastMessage(String message);
        TextWatcher getEmailWatcher();
        TextWatcher getPasswordWatcher();

    }

    interface Presenter extends BasePresenter<View> {
        void setContext(Context context);
        boolean validateFields(String field);
        void validateButton(boolean email, boolean password);
        void onButtonClicked(boolean emailChanged, boolean passwordChanged);






    }
}
