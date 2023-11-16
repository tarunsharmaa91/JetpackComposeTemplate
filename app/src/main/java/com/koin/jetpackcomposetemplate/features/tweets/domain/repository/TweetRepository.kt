package com.koin.jetpackcomposetemplate.features.tweets.domain.repository

import com.koin.jetpackcomposetemplate.common.ApiState
import com.koin.jetpackcomposetemplate.data.model.Tweets.TweetList
import kotlinx.coroutines.flow.Flow

interface TweetRepository {
    suspend fun getTweetList(): Flow<ApiState<TweetList>>
}