package com.example.raluc.challenge.ui

import android.databinding.DataBindingUtil.setContentView
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Toast
import com.example.raluc.challenge.R
import com.example.raluc.challenge.base.BasePresenter
import com.example.raluc.challenge.base.BaseView

abstract class BaseActivity <T: BasePresenter> : AppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()

    }

    override fun onStop() {
        super.onStop()
        getViewPresenter().onStop()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showError(message: String) {
       showDialog(message, "Error")
    }


    private fun showDialog (message: String, title: String){
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("Ok"){dialog, _ -> dialog?.cancel()}
            .show()
    }
    abstract fun getViewPresenter() : T
    abstract fun init()

}
