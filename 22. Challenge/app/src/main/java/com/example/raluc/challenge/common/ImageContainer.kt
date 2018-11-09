package com.example.raluc.challenge.common

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.example.raluc.challenge.R
import kotlinx.android.synthetic.main.imagecontainer_view.view.*

class ImageContainer (context: Context, attrs: AttributeSet): ConstraintLayout(context, attrs) {

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.imagecontainer_view, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        Glide.with(context)
            .load("https://contents.newspicks.us/users/100013/cover?circle=true")
            .into(iv1)
        Glide.with(context)
            .load("https://contents.newspicks.us/users/100269/cover?circle=true")
            .into(iv2)
        Glide.with(context)
            .load("https://contents.newspicks.us/users/100094/cover?circle=true")
            .into(iv3)
        Glide.with(context)
            .load("https://contents.newspicks.us/users/100353/cover?circle=true")
            .into(iv4)
        Glide.with(context)
            .load("https://contents.newspicks.us/users/100019/cover?circle=true")
            .into(iv5)
        Glide.with(context)
            .load("https://contents.newspicks.us/users/100529/cover?circle=true")
            .into(iv6)


    }
}