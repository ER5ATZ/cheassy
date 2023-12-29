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
import ch.eassy.utils.GameSettings
import ch.eassy.utils.GameTypes.Alice
import ch.eassy.utils.GameTypes.Chinese
import ch.eassy.utils.GameTypes.Classic
import ch.eassy.utils.GameTypes.StarTrek
import ch.eassy.utils.Screens.ChooseGame

@Composable
fun ChessGameScreen(
    onBackClick: () -> Unit,
    onDefaultClick: (settings: GameSettings) -> Unit,
    onAliceClick: (settings: GameSettings) -> Unit,
    onChineseClick: (settings: GameSettings) -> Unit,
    onStarTrekClick: (settings: GameSettings) -> Unit
) {
    MenuTheme(ChooseGame.color) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "ChEsS iS eAsY")
            Spacer(modifier = Modifier.height(15.dp))

            MenuButton("Back to Menu", onBackClick)
            Spacer(modifier = Modifier.width(10.dp))
            ThumbnailButton("Classic Chess", Classic, null, onDefaultClick)
            Spacer(modifier = Modifier.width(10.dp))
            ThumbnailButton("Alice Chess", Alice, null, onAliceClick)
            Spacer(modifier = Modifier.width(10.dp))
            ThumbnailButton("Chinese Chess", Chinese, null, onChineseClick)
            Spacer(modifier = Modifier.width(10.dp))
            ThumbnailButton("Star Trek Chess", StarTrek, null, onStarTrekClick)
        }

    }
}