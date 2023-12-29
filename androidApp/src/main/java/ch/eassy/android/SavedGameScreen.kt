package ch.eassy.android

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ch.eassy.datamanagement.SaveGamesProvider
import ch.eassy.utils.GameSettings
import ch.eassy.utils.Screens.SavedGame

@Composable
fun SavedGameScreen(onBackClick: () -> Unit, onContinueClick: (settings: GameSettings) -> Unit) {
    val savedGames = SaveGamesProvider.getRecent()
    MenuTheme(SavedGame.color) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "ChEsS iS eAsY")
            Spacer(modifier = Modifier.height(15.dp))

            MenuButton("Back to Menu", onBackClick) }

        for (sg in savedGames) {
            Spacer(modifier = Modifier.width(10.dp))
            ThumbnailButton(sg.label, sg.type, sg.saveState, onContinueClick)
        }
    }
}
