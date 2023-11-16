package com.koin.jetpackcomposetemplate.data.model.Tweets

data class Data(
    val author_id: String,
    val conversation_id: String,
    val created_at: String,
    val entities: Entities?,
    val id: String,
)