package com.koin.jetpackcomposetemplate.common.base

interface Mapper<F, T> {
    fun fromMap(from: F): T
}