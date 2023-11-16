package com.koin.jetpackcomposetemplate.features.tweets.domain.usecase

import com.koin.jetpackcomposetemplate.common.ApiState
import com.koin.jetpackcomposetemplate.common.map
import com.koin.jetpackcomposetemplate.features.tweets.domain.mapper.TweetMapper
import com.koin.jetpackcomposetemplate.features.tweets.domain.repository.TweetRepository
import com.koin.jetpackcomposetemplate.data.model.Tweets.Data
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TweetUsecase @Inject constructor(
    private val repository: TweetRepository,
    private val mapper: TweetMapper
) {
    suspend fun getTweets(): Flow<ApiState<List<Data>?>> {
        return repository.getTweetList().map { results ->
            results.map {
                mapper.fromMap(it)
            }
        }
    }
}