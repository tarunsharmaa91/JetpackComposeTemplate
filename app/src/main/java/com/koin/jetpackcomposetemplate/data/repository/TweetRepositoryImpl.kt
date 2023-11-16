package com.koin.jetpackcomposetemplate.data.network.repository

import com.koin.jetpackcomposetemplate.common.ApiState
import com.koin.jetpackcomposetemplate.common.base.BaseRepository
import com.koin.jetpackcomposetemplate.data.network.TweetsApi
import com.koin.jetpackcomposetemplate.features.tweets.domain.repository.TweetRepository
import com.koin.jetpackcomposetemplate.data.model.Tweets.TweetList
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TweetRepositoryImpl @Inject constructor(private val tweetsApi: TweetsApi) : TweetRepository, BaseRepository(){
    /*private val _tweetList = MutableSharedFlow<TweetList>()
    val tweetList: SharedFlow<TweetList>
        get() = _tweetList*/

    override suspend fun getTweetList(): Flow<ApiState<TweetList>> = safeApiCall {
        tweetsApi.getTweets()
    }

        /*val response = tweetsApi.getTweets()
        if (response.isSuccessful && response.body() != null) {
            _tweetList.emit(response.body()!!)
        }*/


}