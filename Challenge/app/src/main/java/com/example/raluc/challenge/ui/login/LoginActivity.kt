package com.example.raluc.challenge.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.raluc.challenge.AppController
import com.example.raluc.challenge.databinding.ActivityLoginBinding
import com.example.raluc.challenge.di.activity.ContractModule
import com.example.raluc.challenge.ui.BaseActivity
import com.example.raluc.challenge.ui.mainscreen.MainScreenActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity<LoginContract.Presenter>(), LoginContract.View {

    @Inject
    lateinit var presenter: LoginContract.Presenter

    @Inject
    lateinit var binding: ActivityLoginBinding

    override fun init() {
        (application as AppController)
            .appComponent
            .newActivityComponent(ContractModule(this as BaseActivity<*>))
            .inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.presenter = presenter
    }

    override fun enableLoginButton() {
        btnLogIn.isEnabled = true
    }

    override fun disableLoginButton() {
        btnLogIn.isEnabled = false
    }

    override fun showLoadingIndicator() {
        binding.progressBarSpinner.visibility = View.VISIBLE
    }

    override fun hideLoadingIndicator() {
        binding.progressBarSpinner.visibility = View.INVISIBLE
    }

    override fun setLoginButtonColor(boolean: Boolean) {
        binding.active = boolean
    }

    override fun startMainScreenActivity() {
        val intent = Intent(this, MainScreenActivity::class.java)
        startActivity(intent)
    }

    override fun getViewPresenter(): LoginContract.Presenter = presenter

    fun validateCredentials(view: View) = presenter.validateUser(etEmail.text.toString(), etPassword.text.toString())
}
