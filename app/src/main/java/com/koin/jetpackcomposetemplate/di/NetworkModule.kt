package com.koin.jetpackcomposetemplate.di

import com.koin.jetpackcomposetemplate.data.network.TweetsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
//Below line will create single object in whole app for this module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun providesRetrofit(): TweetsApi{
        return Retrofit.Builder().run {
            baseUrl(TweetsApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        }.create(TweetsApi::class.java)
    }

    /*@Singleton
    @Provides
    fun providesTweetsApi(retrofit: Retrofit): TweetsApi {
        return retrofit.create(TweetsApi::class.java)
    }*/
}