package com.koin.jetpackcomposetemplate.features.tweets.domain.mapper

import com.koin.jetpackcomposetemplate.common.base.Mapper
import com.koin.jetpackcomposetemplate.data.model.Tweets.Data
import com.koin.jetpackcomposetemplate.data.model.Tweets.TweetList
import javax.inject.Inject

class TweetMapper @Inject constructor(): Mapper<TweetList?, List<Data>?>{
    override fun fromMap(from: TweetList?): List<Data>? {
        return from?.data?.map {
            Data(
                id = it.id,
                author_id = it.author_id,
                conversation_id = it.conversation_id,
                created_at = it.created_at,
                entities = it.entities
            )
        }
    }

}