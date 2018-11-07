package com.example.raluc.contentproviders.data.database.dao

import android.arch.persistence.room.*
import android.database.Cursor
import com.example.raluc.contentproviders.data.database.entities.Contact
import io.reactivex.Flowable

@Dao
interface ContactsDao {

    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun insertContact(contact : Contact):Long

    @Update
    fun updateContact(contact : Contact)

    @Delete
    fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contacts")
    fun getContacts() : Flowable<List<Contact>>

    @Query("SELECt * FROM contacts")
    fun getCursorContacts(): Cursor
}