package com.example.raluc.firebasetest

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Sampler
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import com.example.raluc.firebasetest.databinding.ActivityMainBinding
import com.example.raluc.firebasetest.utils.ANONYMOUS
import com.example.raluc.firebasetest.utils.RC_SIGN_IN
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    lateinit var database: FirebaseDatabase
    lateinit var databaseReference: DatabaseReference
    lateinit var binding: ActivityMainBinding
    lateinit var valueEventListener: ValueEventListener
    lateinit var firebaseLayoutManager: LinearLayoutManager
    lateinit var firebaseAdapter: FirebaseAdapter
    lateinit var firebaseAuth: FirebaseAuth
    var messages: ArrayList<Message> = ArrayList()
    val TAG = "MainActivity"
    var userName: String = ANONYMOUS


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initializeRecyclerViewAdapter()
        initializeFirebaseComponents()
        addTextWatchers()
    }


    fun signOut(view: View) {
        AuthUI.getInstance().signOut(this)
            .addOnCompleteListener {
                onSignOutCleanUp()
            }
    }

    private fun onSignOutCleanUp() {
        userName = ANONYMOUS
        firebaseAdapter.clear()
        startFirebaseSignIn()
    }

    private fun startFirebaseSignIn() {
        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setIsSmartLockEnabled(false)
                .setAvailableProviders(
                    listOf(
                        AuthUI.IdpConfig.EmailBuilder().build(),
                        AuthUI.IdpConfig.GoogleBuilder().build()
                    )
                )
                .build(), RC_SIGN_IN
        )

    }

    override fun onResume() {
        super.onResume()
        addReadListeners()
    }

    override fun onPause() {
        super.onPause()
        removeReadListeners()
    }


    private fun addReadListeners() {
        valueEventListener = object : ValueEventListener {

            override fun onCancelled(databaseError: DatabaseError) {
                Log.d(TAG, databaseError.message)
            }


            override fun onDataChange(dataSnapShot: DataSnapshot) {
                messages.clear()
                dataSnapShot.children.forEach { dataSnapShot ->
                    val message = dataSnapShot.getValue(Message::class.java)
                    message?.let {
                        messages.add(it)
                    }
                }
                firebaseAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun removeReadListeners() {
        databaseReference.removeEventListener(valueEventListener)
    }


    fun sendMessage(view: View) {
        var message = Message(binding.messageEditText.text.toString(), userName)
        databaseReference.push().setValue(message)

        // Clear input box
        binding.messageEditText.setText("")
    }

    private fun FirebaseAdapter.clear() {
        chatMessages.clear()
        notifyDataSetChanged()

    }

    private fun addTextWatchers() {
        binding.messageEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                binding.sendButton.isEnabled = charSequence.toString().isNotBlank()
            }

        })
    }

    private fun initializeFirebaseComponents() {
        database = FirebaseDatabase.getInstance()
        databaseReference = database.reference.child("messages")
        firebaseAuth = FirebaseAuth.getInstance()
    }

    private fun initializeRecyclerViewAdapter() {
        firebaseLayoutManager = LinearLayoutManager(this)
        firebaseAdapter = FirebaseAdapter(messages)
        binding.recyclerView.apply {
            adapter = firebaseAdapter
            layoutManager = firebaseLayoutManager
        }
    }

}



