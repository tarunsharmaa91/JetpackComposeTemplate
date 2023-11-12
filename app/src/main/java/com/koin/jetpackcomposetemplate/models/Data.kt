package com.koin.jetpackcomposetemplate.models

data class Data(
    val attachments: Attachments,
    val author_id: String,
    val conversation_id: String,
    val created_at: String,
    val entities: Entities,
    val id: String,
    val referenced_tweets: List<ReferencedTweet>,
    val text: String
)