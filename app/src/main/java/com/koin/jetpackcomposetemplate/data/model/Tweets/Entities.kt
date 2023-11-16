package com.koin.jetpackcomposetemplate.data.model.Tweets

data class Entities(
    val hashtags: List<Hashtag>,
    val mentions: List<Mention>,
    val urls: List<Url>
)