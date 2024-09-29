package com.compose.data.remote.models.responses

import com.compose.domain.models.User
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BaseResponse<T> (
    val code: Int?,
    val message: String?,
    val results: T?
)


