package com.compose.domain.repositories

import com.compose.domain.models.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUser() : Flow<User>
}