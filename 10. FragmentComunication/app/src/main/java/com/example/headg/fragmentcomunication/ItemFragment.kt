package com.example.headg.fragmentcomunication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_fragment.*

class ItemFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.item_fragment, container, false)
        return view
    }

    fun personSelected(person : Person){
        tvName.text = person.name
        tvAge.text = person.age
        tvAnimal.text = person.favoriteAnimal
    }
}