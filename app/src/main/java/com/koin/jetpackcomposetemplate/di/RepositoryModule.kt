package com.koin.jetpackcomposetemplate.di

import androidx.lifecycle.ViewModel
import com.koin.jetpackcomposetemplate.data.network.repository.TweetRepositoryImpl
import com.koin.jetpackcomposetemplate.features.tweets.domain.repository.TweetRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideTweetRepository(
        repo: TweetRepositoryImpl
    ): TweetRepository

}