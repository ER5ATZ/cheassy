package ch.eassy.utils

data class Color(
    val red: Int,
    val green: Int,
    val blue: Int,
    val alpha: Int
) {

    fun toHex(): String {
        return "#${"%02X".let { it + alpha + it + red + it + green + it + blue }}"
    }

    companion object {
        fun create(alpha: Int, red: Int, green: Int, blue: Int): Color {
            return Color(alpha, red, green, blue)
        }

        fun setRed(color: Color, red: Int): Color {
            return color.copy(red = red)
        }

        fun setGreen(color: Color, green: Int): Color {
            return color.copy(green = green)
        }

        fun setBlue(color: Color, blue: Int): Color {
            return color.copy(blue = blue)
        }

        fun setAlpha(color: Color, alpha: Int): Color {
            return color.copy(alpha = alpha)
        }
    }
}
