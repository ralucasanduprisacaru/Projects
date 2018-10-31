package com.example.headg.fragmentcomunication

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.headg.fragmentcomunication.R.attr.layoutManager
import kotlinx.android.synthetic.main.recycler_view_fragment.*
import java.lang.ClassCastException
import kotlin.collections.ArrayList

class RecyclerViewFragment: Fragment() {

    private lateinit var personSelectedCallback: OnPersonSelectedListener
    private lateinit var personList: MutableList<Person>

    interface OnPersonSelectedListener{
        fun onPersonSelected(person: Person)
    }

     override fun onAttach(context: Context?) {
        super.onAttach(context)
         if (context is OnPersonSelectedListener) personSelectedCallback = context
         else throw ClassCastException(context.toString() + " must implement OnPErsonSelectedListener")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.recycler_view_fragment, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        personList = ArrayList()
        personList.add(Person("Bob", "36", "Chicken"))
        personList.add(Person("Colin", "36", "Lion"))
        personList.add(Person("Dave", "39", "Elephant"))
        personList.add(Person("Brian", "36", "Dog"))
        personList.add(Person("Geoff", "36", "Cat"))
        personList.add(Person("Tim", "36", "Turtle"))


        val rvAdapter = PersonRecyclerAdapter(personList, personSelectedCallback)
        val linearLayoutManager = LinearLayoutManager(activity)
        recyclerView.apply{
            adapter = rvAdapter
            layoutManager = linearLayoutManager
        }
    }
}