package ch.eassy.android

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ch.eassy.utils.Screens.Menu

@Composable
fun MenuScreen(
    onStartGameClick: () -> Unit,
    onSavedGameClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onAboutClick: () -> Unit,
) {
    MenuTheme(Menu.color) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = Menu.label)
            Spacer(modifier = Modifier.height(16.dp))

            MenuButton("Start a Game", onStartGameClick)
            Spacer(modifier = Modifier.height(16.dp))
            MenuButton("Saved Games", onSavedGameClick)
            Spacer(modifier = Modifier.height(16.dp))
            MenuButton("Settings", onSettingsClick)
            Spacer(modifier = Modifier.height(16.dp))
            MenuButton("About this app", onAboutClick)
        }
    }
}