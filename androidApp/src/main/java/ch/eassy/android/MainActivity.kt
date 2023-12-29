package ch.eassy.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import ch.eassy.utils.Screens.About
import ch.eassy.utils.Screens.ChooseGame
import ch.eassy.utils.Screens.ColorPicker
import ch.eassy.utils.Screens.Menu
import ch.eassy.utils.Screens.PlayGame
import ch.eassy.utils.Screens.SavedGame
import ch.eassy.utils.Screens.Settings

class MainActivity : ComponentActivity() {
    private var currentScreen by mutableStateOf(Menu)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MenuTheme(bgColor = Menu.color) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    //GreetingView(Greeting().greet())
                    when (currentScreen) {
                        Menu -> MenuScreen(
                            onStartGameClick = { currentScreen = ChooseGame },
                            onSavedGameClick = { currentScreen = SavedGame },
                            onSettingsClick = { currentScreen = Settings },
                            onAboutClick = { currentScreen = About },
                        )
                        ChooseGame -> ChessGameScreen(
                            onBackClick = { currentScreen = Menu },
                            onDefaultClick = { currentScreen = ColorPicker },
                            onAliceClick = { currentScreen = ColorPicker },
                            onChineseClick = { currentScreen = ColorPicker },
                            onStarTrekClick = { currentScreen = ColorPicker },
                        )
                        SavedGame -> SavedGameScreen(
                            onBackClick = { currentScreen = Menu },
                            onContinueClick = { currentScreen = PlayGame },
                        )
                        Settings -> SettingsScreen(
                            onBackClick = { currentScreen = Menu },
                        )
                        About -> CreditsScreen(
                            onBackClick = { currentScreen = Menu },
                        )
                        ColorPicker -> ColorPickerScreen(
                            onBackClick = { currentScreen = ChooseGame },
                            onColorPick = { currentScreen = PlayGame },
                        )
                        PlayGame -> PlayGameScreen(
                            onBackClick = { currentScreen = Menu },
                        )
                    }

                    AnimatedVisibility(
                        visible = currentScreen == Menu,
                        enter = slideInHorizontally(initialOffsetX = { it }),
                        exit = slideOutHorizontally(targetOffsetX = { -it })
                    ) {
                        MenuScreen(
                            onStartGameClick = { currentScreen = ChooseGame },
                            onSavedGameClick = { currentScreen = SavedGame },
                            onSettingsClick = { currentScreen = Settings },
                            onAboutClick = { currentScreen = About })
                    }

                    AnimatedVisibility(
                        visible = currentScreen == ChooseGame,
                        enter = slideInHorizontally(initialOffsetX = { 2*it }),
                        exit = slideOutHorizontally(targetOffsetX = { it })
                    ) {
                        ChessGameScreen({ currentScreen = Menu }, { currentScreen = ColorPicker }, {
                            currentScreen = ColorPicker
                        }, { currentScreen = ColorPicker }) { currentScreen = ColorPicker }
                    }
                }
            }
        }
    }
}
