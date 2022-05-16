package com.koin.jetpackcomposetemplate

import android.content.res.Configuration.UI_MODE_NIGHT_MASK
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.koin.jetpackcomposetemplate.ui.theme.JetpackComposeTemplateTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                        CardList()
                    }

                }
            }
        }
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
            OutlinedButton(onClick = onContinueClicked) {
                Text(text = "Submit")
            }
        }
    }
}

@Composable
fun CardList(array: List<String> = listOf("First", "Second")) {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp)
    ) {
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

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_MASK)
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
