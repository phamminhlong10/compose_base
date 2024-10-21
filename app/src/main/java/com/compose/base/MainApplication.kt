package com.compose.base

import android.app.Application
import com.compose.base.BuildConfig
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setupLogging()
    }

    private fun setupLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}