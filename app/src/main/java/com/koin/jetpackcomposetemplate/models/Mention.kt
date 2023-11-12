package com.koin.jetpackcomposetemplate.models

data class Mention(
    val end: Int,
    val start: Int,
    val username: String
)