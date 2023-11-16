package com.koin.jetpackcomposetemplate.data.network

import com.koin.jetpackcomposetemplate.data.model.Tweets.TweetList
import retrofit2.Response
import retrofit2.http.GET

interface TweetsApi {
    companion object{
        const val BASE_URL = "https://api.jsonbin.io/"
    }

    //With dynamic headers
    /*@GET("/v3/b/654df04a0574da7622c49803?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<TweetList>*/

    @GET("v3/b/654df04a0574da7622c49803?meta=false")
    suspend fun getTweets(): Response<TweetList>

    //Below with with static header
   /* @GET("/v3/b/654df04a0574da7622c49803?meta=false")
    @Headers("X-JSON-Path : tweets..category")
    suspend fun getCategory(): Response<TweetList>*/
}