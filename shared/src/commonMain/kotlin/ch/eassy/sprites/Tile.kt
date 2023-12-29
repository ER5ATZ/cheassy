package ch.eassy.sprites

import ch.eassy.utils.Color
import ch.eassy.utils.Colors
import kotlinx.coroutines.flow.MutableStateFlow

class Tile(name: String, location: Pair<Int, Int>, color: Color) {
    private val tileState = MutableStateFlow(TileState())

    init {
        tileState.value = TileState(
            name = name,
            location = location,
            color = color
        )
    }

    fun setColors(isDark: Boolean, color: Color) {
        tileState.value = TileState(
            isDark = isDark,
            originalColor = color
        )
        resetColor()
    }

    fun setClickable(isClickable: Boolean) {
        tileState.value = TileState(isClickable = isClickable)
    }

    fun setPiece(piece: Piece?) {
        tileState.value = TileState(piece = piece)
    }

    fun addHighlight(alpha: Float, isOrigin: Boolean) {
        val newColor = createHighlight(alpha)
        tileState.value = TileState(color = newColor, isValidTarget = !isOrigin)
    }

    fun onMouseEnter() {
        if (tileState.value.isClickable) {
            val tilePiece = tileState.value.piece
            if (tilePiece != null && isPlayerPiece(tilePiece) && !tilePiece.isSelected()) {
                tilePiece.highlightTiles()
            }
        }
    }

    fun onMouseExit() {
        if (tileState.value.isClickable) {
            val tilePiece = tileState.value.piece
            if (tilePiece != null && isPlayerPiece(tilePiece) && !tileState.value.isMoveOrigin) {
                removeHighlight()
                if (!tilePiece.isSelected()) {
                    tilePiece.removeHighlightFromTiles()
                }
            }
        }
    }

    fun onMouseDown() {
        if (tileState.value.isClickable) {
            when {
                tileState.value.isMoveOrigin -> unsetAsMoveOrigin()
                tileState.value.isValidTarget -> setAsTarget()
                tileState.value.isMoveTarget -> finishMove()
                else -> setAsMoveOrigin()
            }
        }
    }

    private fun setAsMoveOrigin() {
        val tilePiece = tileState.value.piece
        if (tilePiece != null && isPlayerPiece(tilePiece)) {
            tilePiece.toggleSelection()
            tileState.value = TileState(isMoveOrigin = true)
        }
    }

    private fun unsetAsMoveOrigin() {
        val tilePiece = tileState.value.piece
        if (tilePiece != null && isPlayerPiece(tilePiece)) {
            resetOrigin()
            tilePiece.toggleSelection()
            tileState.value = TileState(piece = tilePiece)
        }
    }

    private fun isPlayerPiece(piece: Piece): Boolean {
        // TODO maybe ask the game controller instead though
        return Colors.White.equals(piece.getColor())
    }

    private fun setAsTarget() {
        tileState.value = TileState(isMoveTarget = true)
    }

    fun getName() = tileState.value.name

    fun getLocation() = tileState.value.location

    fun getPiece() = tileState.value.piece

    fun isExpectingPiece() = tileState.value.isMoveTarget

    fun isValidTarget() = tileState.value.isValidTarget

    fun isOrigin() = tileState.value.isMoveOrigin

    private fun resetOrigin() {
        tileState.value = TileState(isMoveOrigin = false)
    }

    private fun finishMove() {
        tileState.value = TileState(isMoveTarget = false)
    }

    private fun removeHighlight() {
        resetColor()
        tileState.value = TileState(isValidTarget = false)
    }

    private fun resetColor() {
        tileState.value = TileState(color = tileState.value.originalColor)
    }

    private fun createHighlight(alpha: Float): Color {
        val highlight = tileState.value.highlightColor
        return Color.create(
            (alpha * 255).toInt(),
            highlight.red,
            highlight.green,
            highlight.blue
        )
    }

    data class TileState(
        val name: String = "Z26",
        val location: Pair<Int, Int> = Pair(0, 0),
        val piece: Piece? = null,
        val isMoveOrigin: Boolean = false,
        val isMoveTarget: Boolean = false,
        val isValidTarget: Boolean = false,
        val color: Color = Colors.Brown,
        val isDark: Boolean = false,
        val originalColor: Color = Colors.Black,
        val highlightColor: Color = Colors.Turquoise,
        val isClickable: Boolean = false,
    )
}
