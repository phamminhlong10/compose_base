package com.compose.domain.usecases

import com.compose.domain.models.User
import com.compose.domain.repositories.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend fun invoke() : Flow<User?>{
      return userRepository.getUser()
    }
}