package com.example.raluc.a20newspickschallenge.ui;


import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.text.Layout;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.example.raluc.a20newspickschallenge.R;

import java.util.List;

public class SecondPresenter implements SecondContract.SPresenter{
    public final String TAG = "SecondPresenter";
    SecondContract.SView sView;
    Context context;


    @Override
    public void attachView(SecondContract.SView view) {
        this.sView = view;
    }

    @Override
    public void removeView(String s) {
        this.sView = null;
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void rotateClockwise(ConstraintLayout layout, List<ImageView> list) {
        RotateAnimation rotate = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(5000);
        rotate.setInterpolator(new LinearInterpolator());
        layout.startAnimation(rotate);
        rotateAntiClockwise(list);
    }

    @Override
    public void rotateAntiClockwise(List<ImageView> list) {
        RotateAnimation rotate = new RotateAnimation(
                360, 0,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(5000);
        rotate.setInterpolator(new LinearInterpolator());
      for (ImageView image : list) {
          image.startAnimation(rotate);
      }
    }

}
