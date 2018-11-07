package com.example.raluc.contentproviders.ui

import android.content.ContentValues
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.LoaderManager
import android.support.v4.content.CursorLoader
import android.support.v4.content.Loader
import android.view.View
import android.widget.Toast
import com.example.raluc.contentproviders.R
import com.example.raluc.contentproviders.common.URL_LOADER
import com.example.raluc.contentproviders.providers.MyContactProviderContract
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() , LoaderManager.LoaderCallbacks<Cursor> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportLoaderManager.initLoader(URL_LOADER, null, this)
    }

    override fun onCreateLoader(loaderId: Int, bundle: Bundle?): Loader<Cursor> {
        return when(loaderId){
            URL_LOADER -> CursorLoader(
                this, // Context
            MyContactProviderContract.MyContentProviderEntry.CONTENT_URI, // table to query
            null, // projection, includes all the columns needed
            null, // selection clause
            null, // selection args
            null // sort order
            )

            else -> throw NullPointerException ()  // don't do in practice. Handle the exception
        }

    }

    override fun onLoadFinished(loader: Loader<Cursor>, cursor: Cursor?) {
        Toast.makeText(this, "Load done", Toast.LENGTH_LONG).show()
    }

    override fun onLoaderReset(p0: Loader<Cursor>) {

    }

    fun insertContact(view: View){
        val contentValues = ContentValues()
        contentValues.put(MyContactProviderContract.MyContentProviderEntry.COLUMN_CONTACT_NAME
        , etContactName.text.toString())
        contentValues.put(MyContactProviderContract.MyContentProviderEntry.COLUMN_CONTACT_RELATIONSHIP
            , etContactRelationship.text.toString())
        contentValues.put(MyContactProviderContract.MyContentProviderEntry.COLUMN_CONTACT_PRIMARY_NUMBER
            , etContactPrimaryNumber.text.toString())

        contentValues.put(MyContactProviderContract.MyContentProviderEntry.COLUMN_CONTACT_SECONDARY_NUMBER
            , etContactSecondaryNumber.text.toString()
        )
        contentResolver.insert(MyContactProviderContract.MyContentProviderEntry.CONTENT_URI, contentValues)
    }
}
