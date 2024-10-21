package com.compose.data.remote.providers

import com.compose.data.remote.services.UserService
import retrofit2.Retrofit

object UserServiceProvider {
    fun getUserService(retrofit: Retrofit) : UserService{
        return retrofit.create(UserService::class.java)
    }
}