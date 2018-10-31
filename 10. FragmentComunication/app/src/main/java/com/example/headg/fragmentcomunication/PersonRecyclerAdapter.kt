package com.example.headg.fragmentcomunication

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class PersonRecyclerAdapter( var personList: List<Person>, val personSelectedListener: RecyclerViewFragment.OnPersonSelectedListener): RecyclerView.Adapter<PersonRecyclerAdapter.viewHolder>() {


    val TAG = "Adapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonRecyclerAdapter.viewHolder {

        Log.d(TAG, "onCreateViewHolder : ")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_recycler_list_item, null)
        return viewHolder(view)
    }

    override fun getItemCount() = personList.size

    override fun onBindViewHolder(holder: PersonRecyclerAdapter.viewHolder, position: Int) {
        val personTemp = personList[position]

        holder.apply{
            tvPersonName.text = personTemp.name
            tvPersonAge.text = personTemp.age
            tvPersonAnimal.text = personTemp.favoriteAnimal
            itemView.setOnClickListener(){
                personSelectedListener.onPersonSelected(personTemp)
            }
        }




    }

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvPersonName : TextView = itemView.findViewById(R.id.rvTVName)
        val tvPersonAge : TextView = itemView.findViewById(R.id.rvTVAge)
        val tvPersonAnimal : TextView = itemView.findViewById(R.id.rvTVAnimal)

    }




}