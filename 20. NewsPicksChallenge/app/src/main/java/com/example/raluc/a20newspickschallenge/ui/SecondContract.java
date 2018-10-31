package com.example.raluc.a20newspickschallenge.ui;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.widget.ImageView;

import com.example.raluc.a20newspickschallenge.base.BasePresenter;
import com.example.raluc.a20newspickschallenge.base.BaseView;

import java.util.List;

public interface SecondContract {

    interface SView extends BaseView {
        void bind();
        void loadImages(ImageView imageView, String url);

    }


    interface SPresenter extends BasePresenter <SView> {
        void setContext(Context context);
        void rotateClockwise(ConstraintLayout layout, List<ImageView> list);
        void rotateAntiClockwise(List<ImageView> list);
    }
}
