package com.example.raluc.contentproviders.providers

import android.arch.persistence.room.Room
import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.database.Observable
import android.net.Uri
import com.example.raluc.contentproviders.common.DATABASE_NAME
import com.example.raluc.contentproviders.common.TABLE_NAME
import com.example.raluc.contentproviders.data.database.ContactsDatabase
import com.example.raluc.contentproviders.data.database.entities.Contact
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Action
import io.reactivex.internal.util.HalfSerializer.onComplete
import io.reactivex.plugins.RxJavaPlugins.onSubscribe
import io.reactivex.schedulers.Schedulers

class MyContentProvider : ContentProvider() {

    val CONTACT_URI_CODE = 10
    private lateinit var contactsDatabase: ContactsDatabase
    private lateinit var uriMatcher: UriMatcher

    override fun onCreate(): Boolean {
        contactsDatabase = Room.databaseBuilder(context, ContactsDatabase::class.java, DATABASE_NAME).build()
        uriMatcher = createUriMatcher()
        return true
    }

    private fun createUriMatcher(): UriMatcher {
        val matcher = UriMatcher(UriMatcher.NO_MATCH)
        val authority = MyContactProviderContract.CONTENT_AUTHORITY

        matcher.addURI(authority, TABLE_NAME, CONTACT_URI_CODE)
        return matcher
    }

    override fun insert(uri: Uri, contentValues: ContentValues?): Uri? {
        when (uriMatcher.match(uri)) {
            CONTACT_URI_CODE -> {
                contentValues?.let {

                    // use rxjava to do the insert
                    Completable.fromAction {
                        contactsDatabase.contactsDao().insertContact(
                            contact = Contact(
                                contactName = it["contactName"] as String,
                                contactRelationship = it["contactRelationship"] as String,
                                contactPrimaryNumber = it["contactPrimaryNumber"] as String,
                                contactSecondaryNumber = it["contactSecondaryNumber"] as String
                            )
                        )
                    }.observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe { context.contentResolver.notifyChange(uri, null) }
                }


                /*   Open a thread to do the insert
                    Thread {
                        contactsDatabase.contactsDao().insertContact(
                            Contact(contactName = it["contactName"] as String,
                                contactRelationship = it["contactRelationship"] as String,
                                contactPrimaryNumber = it["contactPrimaryNumber"] as String,
                                contactSecondaryNumber = it["contactSecondaryNumber"] as String)
                        )
                    }.start()
                    context.contentResolver.notifyChange(uri, null)
                    */
            }
        }
        return MyContactProviderContract.BASE_CONTENT_URI
}

override fun query(
    uri: Uri,
    projection: Array<String>?,
    selection: String?,
    selectionArgs: Array<String>?,
    sortOrder: String?
): Cursor? = contactsDatabase.contactsDao().getCursorContacts()


override fun update(uri: Uri, contentValues: ContentValues?, selection: String?, selectionArgs: Array<String>?): Int {
return 1
}

override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
    return 1
}

override fun getType(uri: Uri): String? {
    return ""
}
}