package com.koin.jetpackcomposetemplate.api

import com.koin.jetpackcomposetemplate.models.TweetList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsApi {

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