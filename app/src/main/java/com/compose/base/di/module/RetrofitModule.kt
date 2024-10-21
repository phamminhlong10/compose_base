package com.compose.base.di.module

import com.compose.base.BuildConfig
import com.compose.data.remote.providers.ConverterFactoryProvider
import com.compose.data.remote.providers.RetrofitProvider
import com.compose.data.remote.providers.UserServiceProvider
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {
    @Provides
    fun provideBaseUrl() = BuildConfig.BASE_API_URL

    @Provides
    fun provideMoshiConverterFactory(moshi: Moshi) : Converter.Factory =
        ConverterFactoryProvider.converterFactoryProvider(moshi)

    @Provides
    fun provideRetrofit(baseApiUrl: String, okHttpClient: OkHttpClient, converter: Converter.Factory)
        : Retrofit = RetrofitProvider.retrofitBuilder(baseApiUrl, okHttpClient, converter).build()

    @Provides
    fun provideUserService(retrofit: Retrofit) = UserServiceProvider.getUserService(retrofit)
}