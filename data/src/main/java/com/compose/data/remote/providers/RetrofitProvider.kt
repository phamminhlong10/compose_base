package com.compose.data.remote.providers

import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit

object RetrofitProvider {
    fun retrofitBuilder(baseUrl: String, okHttpClient: OkHttpClient,
                       converter: Converter.Factory) : Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(converter)
    }
}