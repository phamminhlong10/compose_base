package com.compose.base.di.module

import com.compose.data.repositories.UserRepositoryImp
import com.compose.domain.repositories.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindUserRepository(userRepositoryImp: UserRepositoryImp) : UserRepository
}