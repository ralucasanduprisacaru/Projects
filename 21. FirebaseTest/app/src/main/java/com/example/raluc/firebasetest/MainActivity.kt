package com.example.raluc.firebasetest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.raluc.firebasetest.databinding.ActivityMainBinding
import com.example.raluc.firebasetest.utils.ANONYMOUS
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

    lateinit var database: FirebaseDatabase
    lateinit var databaseReference: DatabaseReference
    lateinit var binding: ActivityMainBinding
    lateinit var valueEventListener: ValueEventListener
    lateinit var firebaseLayoutManager : LinearLayoutManager
    lateinit var firebaseAdapter : FirebaseAdapter
    lateinit var firebaseAuth: FirebaseAuth
    var messages : ArrayList<Message> = ArrayList()
    val TAG = "MainActivity"
    val userName : String = ANONYMOUS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun signOut(view: View){

    }

    fun sendMessage(view: View){

    }
}
