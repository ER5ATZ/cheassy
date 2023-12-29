package ch.eassy.android

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun MenuButton(text: String, action: () -> Unit) {
    Button(onClick = { action() }) {
        Text(text)
    }
}