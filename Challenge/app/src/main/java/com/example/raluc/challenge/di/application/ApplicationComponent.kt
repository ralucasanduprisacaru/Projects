package com.example.raluc.challenge.di.application

import com.example.raluc.challenge.di.activity.ActivityComponent
import com.example.raluc.challenge.di.activity.ContractModule
import dagger.Component

@ApplicationScope
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun newActivityComponent(contractModule: ContractModule): ActivityComponent
}