package ch.eassy.sprites

import ch.eassy.utils.Color
import ch.eassy.utils.Colors
import ch.eassy.utils.Origin
import ch.eassy.utils.Sprite
import kotlinx.coroutines.flow.MutableStateFlow

abstract class Traits(
    sprite: Sprite,
    color: Color,
    origins: List<Origin>
) {
    private val pieceState = MutableStateFlow(PieceState())

    init {
        pieceState.value = PieceState(
            sprite = sprite,
            color = color,
            origins = origins
        )
    }

    fun getType(): String = pieceState.value.type

    fun getSprite(): Sprite = pieceState.value.sprite

    fun getColor(): Color = pieceState.value.color

    fun getOrigins(): List<Origin> = pieceState.value.origins

    fun setColor(color: Color) {
        pieceState.value = PieceState(color = color)
    }

    fun setType(type: String) {
        pieceState.value = PieceState(type = type)
    }

    fun setSelected(isSelected: Boolean) {
        pieceState.value = PieceState(isSelected = isSelected)
    }

    fun isSelected() = pieceState.value.isSelected

    open fun isLegalMove(tile: Tile) = false

    fun isSafeMove(tile: Tile) = true

    private data class PieceState(
        val type: String = "none",
        val sprite: Sprite = Sprite(),
        val origins: List<Origin> = emptyList(),
        val color : Color = Colors.black,
        val isSelected: Boolean = false,
    )
}