package ch.eassy.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ch.eassy.utils.Colors

@Composable
fun MenuTheme(
    bgColor: Colors,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors(
            primary = Color(0xFFBB86FC),
            primaryVariant = Color(0xFF3700B3),
            secondary = Color(0xFF03DAC5),
            background = getBackground(Color.DarkGray, bgColor)
        )
    } else {
        lightColors(
            primary = Color(0xFF6200EE),
            primaryVariant = Color(0xFF3700B3),
            secondary = Color(0xFF03DAC5),
            background = getBackground(Color.LightGray, bgColor)
        )
    }
    val typography = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

fun getBackground(brightness: Color, shade: Colors): Color {
    val clampedRatio = 0.5f
    val grayFactor = 1 - clampedRatio

    val blendedRed = (brightness.red * grayFactor) + (shade.color.red * clampedRatio)
    val blendedGreen = (brightness.green * grayFactor) + (shade.color.green * clampedRatio)
    val blendedBlue = (brightness.blue * grayFactor) + (shade.color.blue * clampedRatio)

    return Color(
        red = blendedRed.coerceIn(0f, 1f),
        green = blendedGreen.coerceIn(0f, 1f),
        blue = blendedBlue.coerceIn(0f, 1f),
        alpha = 1f
    )
}
