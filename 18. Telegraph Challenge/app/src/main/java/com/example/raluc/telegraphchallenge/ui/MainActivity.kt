package com.example.raluc.telegraphchallenge.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.raluc.telegraphchallenge.R
import com.example.raluc.telegraphchallenge.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var activityMainBinding : ActivityMainBinding

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
