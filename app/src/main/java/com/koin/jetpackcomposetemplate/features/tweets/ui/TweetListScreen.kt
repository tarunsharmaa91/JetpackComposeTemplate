package com.koin.jetpackcomposetemplate.features.tweets.ui

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun TweetListScreen(viewModel: TweetViewModel = hiltViewModel()) {
    //val tweetViewModel: TweetViewModel = viewModel()
    //val sharedFlow = MutableSharedFlow<TweetList>()

    /*LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {

    }*/
    val res = viewModel.response.value
    if(res.isLoading){
        Box(modifier = Modifier.fillMaxSize()){
            CircularProgressIndicator()
        }
    }
    if(res.error.isNotEmpty()){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Text(text = res.error)
        }
    }

    if(res.tweetList.isNotEmpty()){
        /*LazyColumn{
            items(
                res.tweetList,
                key = {
                    it.id!!
                }
            ){ res ->
                TweetItem(res = res.)
            }
        }*/
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ){
            items(res.tweetList.size){
                item -> TweetItem(id = "ttttt")
            }
        }
    }


}

@Composable
fun TweetItem(id: String) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .size(160.dp)
            .clip(RoundedCornerShape(8.dp))
            .border(1.dp, Color(0xFFEEEEEE)),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text = id,
                fontSize = 10.sp,
                color = Color.Black,
                modifier = Modifier.padding(0.dp, 20.dp),
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_MASK, showSystemUi = true)
@Composable
fun AppPreview() {
    TweetItem("test")
}