package com.example.raluc.challenge.ui.mainscreen


import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import com.example.raluc.challenge.AppController
import com.example.raluc.challenge.databinding.ActivityMainBinding
import com.example.raluc.challenge.di.activity.ContractModule
import com.example.raluc.challenge.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainScreenActivity : BaseActivity<MainScreenContract.Presenter>(), MainScreenContract.View {

    @Inject
    lateinit var mainScreenPresenter: MainScreenContract.Presenter

    @Inject
    lateinit var binding: ActivityMainBinding

    override fun init() {
        (application as AppController)
            .appComponent
            .newActivityComponent(ContractModule(this as BaseActivity<*>))
            .inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRotationAnimation(0f, 360f)
        imageContainer.setOnTouchListener { _, motionEvent ->
            mainScreenPresenter.changeCircleRevolution(motionEvent)
        }
    }

    override fun setRotationAnimation(fromDegrees: Float, toDegrees: Float) {
        val rotate = RotateAnimation(
            fromDegrees, toDegrees, Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotate.apply {
            duration = 3000
            interpolator = LinearInterpolator()
            repeatCount = Animation.INFINITE
        }
        imageContainer.startAnimation(rotate)
    }

    override fun getViewPresenter(): MainScreenContract.Presenter = mainScreenPresenter
}

