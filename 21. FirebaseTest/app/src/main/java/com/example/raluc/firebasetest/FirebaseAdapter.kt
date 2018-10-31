package com.example.raluc.firebasetest

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.raluc.firebasetest.databinding.ItemMessageBinding

class FirebaseAdapter (var chatMessages: ArrayList<Message> ) : RecyclerView.Adapter<FirebaseAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirebaseAdapter.ViewHolder {
       val binding = DataBindingUtil.inflate<ItemMessageBinding>(LayoutInflater.from(parent.context),
           R.layout.item_message, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = chatMessages.size

    override fun onBindViewHolder(holder: FirebaseAdapter.ViewHolder, position: Int) {
       val temp = chatMessages[position]
        holder.binding.apply {
            messageTextView.text = temp.text
            nameTextView.text = temp.name
        }
    }

    class ViewHolder (var binding: ItemMessageBinding): RecyclerView.ViewHolder(binding.root)


}