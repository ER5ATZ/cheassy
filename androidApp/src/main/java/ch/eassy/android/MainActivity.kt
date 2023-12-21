package ch.eassy.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    private var currentScreen by mutableStateOf(Screen.Menu)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MenuTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //GreetingView(Greeting().greet())
                    when (currentScreen) {
                        Screen.Menu -> MenuScreen(onStartGameClick = { currentScreen = Screen.ChessGame })
                        Screen.ChessGame -> ChessGameScreen()
                    }

                    AnimatedVisibility(
                        visible = currentScreen == Screen.Menu,
                        enter = slideInHorizontally(initialOffsetX = { it }),
                        exit = slideOutHorizontally(targetOffsetX = { -it })
                    ) {
                        MenuScreen(onStartGameClick = { currentScreen = Screen.ChessGame })
                    }

                    AnimatedVisibility(
                        visible = currentScreen == Screen.ChessGame,
                        enter = slideInHorizontally(initialOffsetX = { 2*it }),
                        exit = slideOutHorizontally(targetOffsetX = { it })
                    ) {
                        ChessGameScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun MenuScreen(onStartGameClick: () -> Unit) {
    MenuTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Chess App")
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { /* Navigate to ColorPickerScreen */ }) {
                Text("Pick Player Color")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { onStartGameClick() }) {
                Text("Start New Game")
            }
        }
    }
}

@Composable
fun ChessGameScreen() {
    // TODO: Implement the UI for the chess game screen
}

enum class Screen {
    Menu,
    ChessGame
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}
@Preview
@Composable
fun DefaultPreview() {
    MenuTheme {
        GreetingView("Hello, Android!")
    }
}
