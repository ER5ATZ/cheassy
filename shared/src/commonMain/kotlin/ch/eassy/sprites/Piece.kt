package ch.eassy.sprites

import ch.eassy.utils.Color
import ch.eassy.utils.Origin
import ch.eassy.utils.Sprite

import kotlinx.datetime.Clock

abstract class Piece(sprite: Sprite, color: Color, origins: List<Origin>): Traits(sprite, color, origins) {
    val id = Clock.System.now().toEpochMilliseconds()
    private lateinit var tile: Tile
    fun highlightTiles() {
        // TODO
    }

    fun removeHighlightFromTiles() {
        // TODO
    }

    fun toggleMarkForMove() {
        super.setSelected(!super.isSelected())
    }

    fun getTile() = tile

    open fun moveTo(targetTile: Tile) {
        if (tile != null) {
            tile.setPiece(null)
        }
        targetTile.setPiece(this)
        tile = targetTile
    }
}
