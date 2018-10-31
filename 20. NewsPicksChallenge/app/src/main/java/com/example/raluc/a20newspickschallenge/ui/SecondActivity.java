package com.example.raluc.a20newspickschallenge.ui;

import android.animation.ObjectAnimator;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.raluc.a20newspickschallenge.R;
import com.example.raluc.a20newspickschallenge.di.DaggerSecondActivityComponent;
import com.example.raluc.a20newspickschallenge.ui.SecondContract.SView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class SecondActivity extends AppCompatActivity implements SView{

    private ImageView image1, image2, image3, image4, image5, image6;
    private ConstraintLayout layout;
    private List<ImageView> imageList;


    @Inject
    SecondPresenter secondPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        DaggerSecondActivityComponent.create().inject(this);
        secondPresenter.attachView(this);
        secondPresenter.setContext(this);

        bind();
        bindImages();
        secondPresenter.rotateClockwise(layout, imageList);

    }


    @Override
    public void showError(String s) {
        Toast.makeText(this, "", Toast.LENGTH_LONG).show();
    }

    @Override
    public void bind() {
        image1 = findViewById(R.id.imageView1);
        image2 = findViewById(R.id.imageView2);
        image3 = findViewById(R.id.imageView3);
        image4 = findViewById(R.id.imageView4);
        image5 = findViewById(R.id.imageView5);
        image6 = findViewById(R.id.imageView6);

        // the constraintLayout will be rotated
        layout = findViewById(R.id.layout);
        imageList = new ArrayList<>();
        populateList();

    }

    public void populateList(){
        // populates a list with all the images
        imageList.add(image1);
        imageList.add(image2);
        imageList.add(image3);
        imageList.add(image4);
        imageList.add(image5);
        imageList.add(image6);
    }

    @Override
    public void loadImages(ImageView imageView, String url) {
        Glide.with(this).load(url).into(imageView);
    }


    private void bindImages() {
        loadImages(image1,"https://contents.newspicks.us/users/100013/cover?circle=true");
        loadImages(image2,"https://contents.newspicks.us/users/100269/cover?circle=true");
        loadImages(image3,"https://contents.newspicks.us/users/100094/cover?circle=true");
        loadImages(image4,"https://contents.newspicks.us/users/100353/cover?circle=true");
        loadImages(image5,"https://contents.newspicks.us/users/100019/cover?circle=true");
        loadImages(image6,"https://contents.newspicks.us/users/100529/cover?circle=true");
    }

}
