package com.example.raluc.challenge.ui.mainscreen

import android.view.MotionEvent
import com.example.raluc.challenge.base.BasePresenter
import com.example.raluc.challenge.base.BaseView

interface MainScreenContract {
    interface View: BaseView {
        fun setRotationAnimation(fromDegrees: Float, toDegrees: Float)
    }

    interface Presenter : BasePresenter {
        fun changeCircleRevolution(motionEvent: MotionEvent): Boolean
    }
}