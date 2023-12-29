package ch.eassy.android

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import ch.eassy.utils.GameSettings
import ch.eassy.utils.GameTypes
import ch.eassy.utils.SaveState

@Composable
fun ThumbnailButton(text: String, type: GameTypes, state: SaveState?, action: (settings: GameSettings) -> Unit) {
    val settings = GameSettings(type, state)
    Button(onClick = { action(settings) }) {
        Text(text)
    }
}