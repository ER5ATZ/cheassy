package ch.eassy

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

class PickerFactory : CoroutineScope by MainScope() {
/*
    lateinit var gameController: GameController
    lateinit var players: List<String>
    var buttonSpacing = 20f

    private lateinit var availableColors: List<Color>

    fun start() {
        availableColors = generateColors()

        generatePickerButtons()
    }

    private fun generateColors(): List<Color> {
        var color = Color.WHITE
        return players.map {
            availableColors.add(color)
            color = color.copy(r = maxOf(0f, color.r - 1 / 255.0f),
                g = maxOf(0f, color.g - 1 / 255.0f),
                b = maxOf(0f, color.b - 1 / 255.0f))
            color
        }
    }

    private fun generatePickerButtons() {
        verticalLayout {
            val buttonCount = availableColors.size
            val totalWidth = (buttonCount - 1) * buttonSpacing

            val startX = -totalWidth / 2

            availableColors.forEachIndexed { index, color ->
                createColorPickerButton(color, startX + index * buttonSpacing)
            }
        }
    }

    private fun createColorPickerButton(color: Color, startX: Float) {
        button {
            textColor = android.graphics.Color.TRANSPARENT
            backgroundResource = R.drawable.picker_button_selector
            onClick {
                launch {
                    val pawn = Pawn().apply { resetColor(color) }
                    gameController.onPickerClicked(color, pawn)
                }
            }

            imageView {
                val pawn = Pawn().apply { resetColor(color) }
                imageResource = pawn.imageResource
            }.lparams {
                width = wrapContent
                height = wrapContent
            }

            layoutParams = LinearLayout.LayoutParams(wrapContent, wrapContent).apply {
                gravity = Gravity.CENTER
                marginStart = startX.toInt()
            }
        }
    }*/
}
