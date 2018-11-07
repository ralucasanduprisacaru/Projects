package com.example.raluc.contentproviders.providers

import android.net.Uri
import android.provider.BaseColumns
import com.example.raluc.contentproviders.common.TABLE_NAME

object MyContactProviderContract {
    val CONTENT_AUTHORITY = "com.example.raluc.contentproviders"
    val BASE_CONTENT_URI = Uri.parse("content://$CONTENT_AUTHORITY")

    object MyContentProviderEntry : BaseColumns {
        val CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build()

        val COLUMN_CONTACT_NAME = "contactName"
        val COLUMN_CONTACT_RELATIONSHIP = "contactRelationship"
        val COLUMN_CONTACT_PRIMARY_NUMBER = "contactPrimaryNumber"
        val COLUMN_CONTACT_SECONDARY_NUMBER = "contactSecondaryNumber"
    }
}