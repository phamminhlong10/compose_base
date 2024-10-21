package com.compose.base.di.module

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.compose.data.local.EncryptedSharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

private const val APP_PREFERENCES = "app_preferences"

@Module
@InstallIn(SingletonComponent::class)
class StorageModule {

    @Provides
    fun provideAppPreferencesDataStore(@ApplicationContext context: Context) : DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            produceFile = {context.preferencesDataStoreFile(APP_PREFERENCES)}
        )
    }


    @Provides
    fun provideSecureStorage(@ApplicationContext context: Context) = EncryptedSharedPreferences(context)
}