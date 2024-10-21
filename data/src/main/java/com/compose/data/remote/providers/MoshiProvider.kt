package com.compose.data.remote.providers

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object MoshiProvider {
    val moshi: Moshi.Builder
        get() = Moshi.Builder().add(KotlinJsonAdapterFactory())
}