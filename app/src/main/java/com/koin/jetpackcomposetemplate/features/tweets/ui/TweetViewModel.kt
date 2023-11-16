package com.koin.jetpackcomposetemplate.features.tweets.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.koin.jetpackcomposetemplate.common.doOnFailure
import com.koin.jetpackcomposetemplate.common.doOnLoading
import com.koin.jetpackcomposetemplate.common.doOnSuccess
import com.koin.jetpackcomposetemplate.features.tweets.domain.usecase.TweetUsecase
import com.koin.jetpackcomposetemplate.data.model.Tweets.Data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TweetViewModel
@Inject constructor(private val tweetUsecase: TweetUsecase) : ViewModel() {

    private val _res = mutableStateOf(TweetListState())
    val response: State<TweetListState> = _res

    init {
        viewModelScope.launch {
            tweetUsecase.getTweets().doOnSuccess {
                _res.value = TweetListState(
                    tweetList = it!!
                )
            }.doOnFailure {
                _res.value = TweetListState(
                    error = it?.message!!
                )
            }.doOnLoading {
                _res.value = TweetListState(
                    isLoading = true
                )
            }.collect()

        }
    }


}

data class TweetListState(
    val tweetList: List<Data> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
) {

}