package com.koin.jetpackcomposetemplate.models

data class Entities(
    val hashtags: List<Hashtag>,
    val mentions: List<Mention>,
    val urls: List<Url>
)