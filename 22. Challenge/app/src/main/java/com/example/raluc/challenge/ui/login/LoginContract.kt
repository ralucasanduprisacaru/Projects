package com.example.raluc.challenge.ui.login

import com.example.raluc.challenge.base.BasePresenter
import com.example.raluc.challenge.base.BaseView

interface LoginContract {
    interface View : BaseView {
        fun enableLoginButton()
        fun disableLoginButton()
        fun showLoadingIndicator()
        fun hideLoadingIndicator()
        fun setLoginButtonColor(boolean: Boolean)
        fun startMainScreenActivity()
    }

    interface Presenter : BasePresenter {
        fun validateUser(email : String, password : String)
        fun  setLoginButtonColor(email: String, password: String)
    }
}