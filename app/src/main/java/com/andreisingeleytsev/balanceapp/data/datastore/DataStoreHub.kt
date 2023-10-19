package com.andreisingeleytsev.playingquizapp.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.andreisingeleytsev.balanceapp.common.Constants

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = Constants.DATASTORE_KEY)

class DataStoreHub(context: Context) {
    val dataStore = context.dataStore
}