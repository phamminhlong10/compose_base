package com.compose.data.repositories

import com.compose.data.extensions.flowTransform
import com.compose.data.remote.services.UserService
import com.compose.domain.models.User
import com.compose.domain.repositories.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImp  @Inject constructor(private val userService: UserService) : UserRepository {
    override suspend fun getUser(): Flow<User?> = flowTransform {
        userService.getUser().results
    }
}