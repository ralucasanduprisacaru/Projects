package com.example.raluc.challenge.di.activity

import android.app.Activity
import android.databinding.DataBindingUtil
import com.example.raluc.challenge.R
import com.example.raluc.challenge.databinding.ActivityLoginBinding
import com.example.raluc.challenge.databinding.ActivityMainBinding
import com.example.raluc.challenge.ui.BaseActivity
import com.example.raluc.challenge.ui.login.LoginContract
import com.example.raluc.challenge.ui.login.LoginPresenter
import com.example.raluc.challenge.ui.mainscreen.MainScreenContract
import com.example.raluc.challenge.ui.mainscreen.MainScreenPresenter
import dagger.Module
import dagger.Provides

@Module
class ContractModule (private val baseActivity: BaseActivity<*>) {
    @Provides
    @ActivityScope
    fun providesLoginContractPresenter(): LoginContract.Presenter = LoginPresenter(baseActivity as LoginContract.View)

    @Provides
    @ActivityScope

    fun providesLoginActivityBinding() : ActivityLoginBinding =
            DataBindingUtil.setContentView(baseActivity as Activity, R.layout.activity_login)

    @Provides
    @ActivityScope
    fun providesMainScreenPresenter() : MainScreenContract.Presenter = MainScreenPresenter(baseActivity as MainScreenContract.View)

    @Provides
    @ActivityScope
    fun providesMainScreenActivityBinding(): ActivityMainBinding =
        DataBindingUtil.setContentView(baseActivity as Activity, R.layout.activity_main)

}