package com.example.raluc.challenge.di.activity

import com.example.raluc.challenge.ui.login.LoginActivity
import com.example.raluc.challenge.ui.mainscreen.MainScreenActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ContractModule::class])
interface ActivityComponent {


    fun inject(loginActivity: LoginActivity)

    fun inject(mainScreenActivity: MainScreenActivity)
}