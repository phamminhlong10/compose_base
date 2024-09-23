package com.compose.domain.exceptions

object NoConnectivityException : RuntimeException()

data class NetworkException(
    val error: Error?,
    val httpCode: Int,
    val httpMessage: String?
) : RuntimeException()