package com.koin.jetpackcomposetemplate.data.model.Tweets

data class Error(
    val detail: String,
    val parameter: String,
    val resource_type: String,
    val title: String,
    val type: String,
    val value: String
)