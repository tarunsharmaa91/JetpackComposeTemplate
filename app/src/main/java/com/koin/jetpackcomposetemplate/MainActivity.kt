package com.koin.jetpackcomposetemplate

import android.content.res.Configuration.UI_MODE_NIGHT_MASK
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.koin.jetpackcomposetemplate.api.TweetsApi
import com.koin.jetpackcomposetemplate.ui.theme.JetpackComposeTemplateTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var tweetsApi: TweetsApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch {
            var response = tweetsApi.getTweets()
            Log.d("Response", response.body().toString())
        }
        setContent {
            JetpackComposeTemplateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var shouldShowMainScreen by remember {
                        mutableStateOf(true)
                    }
                    if (shouldShowMainScreen) {
                        MyApp(onContinueClicked = { shouldShowMainScreen = false })
                    } else {
                        ShowListing()
                    }

                }
            }
        }
    }

    @Composable
    fun ShowListing() {
        LazyColumn(content = {
            items(getCategoryList()){
                value -> CardList(name = value.name)
            }
        })
    }
    
    @Composable
    fun getList (name: String, desc: String){
        CardList()
    }
    

    data class Item(val name: String, val desc: String)

    private fun getCategoryList(): MutableList<Item> {
        val listOfItems = mutableListOf<Item>()
        listOfItems.add(Item(name = "Test", desc = "NO"))
        listOfItems.add(Item(name = "Test1hyv", desc = "NO"))
        listOfItems.add(Item(name = "Tesdufiyt", desc = "NO"))
        listOfItems.add(Item(name = "Tejhfst", desc = "NO"))
        listOfItems.add(Item(name = "Tkhbfjest", desc = "NO"))
        listOfItems.add(Item(name = "Thest", desc = "NO"))
        listOfItems.add(Item(name = "Tesfjht", desc = "NO"))
        listOfItems.add(Item(name = "Tcjhest", desc = "NO"))
        return listOfItems
    }
}

@Composable
fun MyApp(onContinueClicked: () -> Unit) {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxSize(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text("This is a demo text", modifier = Modifier.padding(10.dp))
            val state = remember{
                mutableStateOf("")
            }
            TextField(
                value = state.value,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(1f),
                label = { Text("This is Text field", color = Color.White)},
                onValueChange = {
                    state.value = it },
            )
            OutlinedButton(onClick = onContinueClicked) {
                Text(text = "Submit")
            }
        }
    }
}

@Composable
fun CardList(array: List<String> = listOf("First", "Second"), name : String = "test") {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp)
    ) {
        Text(text = name)
        Column(modifier = Modifier.padding(24.dp)) {
            for (name in array) {
                Card(name = name)
            }
        }
    }
}

@Composable
fun Card(name: String) {
    var expended by remember { mutableStateOf(false) }
    val paddingValue = if (expended) 60.dp else 0.dp

    //State hoisting
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp)
    ) {
        Row(modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = paddingValue)
            ) {
                Text(text = "Hello!")
                Text(text = "$name")
            }
            OutlinedButton(onClick = {
                expended = !expended
            }) {
                Text(text = if (expended) "Show Less" else "Show More")
            }
        }
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_MASK, showSystemUi = true)
@Composable
fun AppPreview() {
    JetpackComposeTemplateTheme {
        MyApp(onContinueClicked = {})
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTemplateTheme {
        CardList()
    }
}
