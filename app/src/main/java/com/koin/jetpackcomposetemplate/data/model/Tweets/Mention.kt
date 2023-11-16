package com.koin.jetpackcomposetemplate.data.model.Tweets

data class Mention(
    val end: Int,
    val start: Int,
    val username: String
)