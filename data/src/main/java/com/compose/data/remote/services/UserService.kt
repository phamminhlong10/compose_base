package com.compose.data.remote.services

import com.compose.data.remote.models.responses.BaseResponse
import com.compose.domain.models.User
import retrofit2.http.GET

interface UserService{
    @GET("user")
    suspend fun getUser() : BaseResponse<User>
}