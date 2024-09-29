package com.compose.domain.repositories

import com.compose.domain.models.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUser() : Flow<User?>
}