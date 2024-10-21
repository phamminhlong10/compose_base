package com.compose.base.di.module

import com.compose.data.remote.providers.MoshiProvider
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MoshiModule {
    @Provides
    fun provideMoshi() : Moshi = MoshiProvider.moshi.build()
}