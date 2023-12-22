package ch.eassy.sprites

import ch.eassy.utils.Color
import ch.eassy.utils.Origin
import ch.eassy.utils.Sprite

import kotlin.math.abs
import kotlinx.datetime.Clock

abstract class Piece(sprite: Sprite, color: Color, origins: List<Origin>): Traits(sprite, color, origins) {
    val id = Clock.System.now().toEpochMilliseconds()

    // a piece always has a tile
    private lateinit var tile: Tile
    fun highlightTiles() {
        // TODO
    }

    fun removeHighlightFromTiles() {
        // TODO
    }

    fun toggleSelection() {
        super.setSelected(!super.isSelected())
    }

    fun getTile() = tile

    open fun moveTo(targetTile: Tile) {
        tile.setPiece(null)
        targetTile.setPiece(this)
        tile = targetTile
    }

    open fun isLegalAttack(targetPiece: Piece?): Boolean {
        return targetPiece != null && targetPiece.getColor() != getColor()
    }

    fun isStraightPathFree(start: Pair<Int, Int>, target: Pair<Int, Int>): Boolean {
        val minY = minOf(start.second, target.second)
        val maxY = maxOf(start.second, target.second)
        val minX = minOf(start.first, target.first)
        val maxX = maxOf(start.first, target.first)

        for (i in 1 until maxOf(maxX - minX, maxY - minY)) {
            val x = start.first + i * target.first
            val y = start.second + i * target.second

            if (pieceExistsAtPosition(Pair(x, y))) {
                return false
            }
        }

        return true
    }

    fun isDiagonalPathFree(start: Pair<Int, Int>, target: Pair<Int, Int>): Boolean {
        val deltaX = abs(start.first - target.first)
        val deltaY = abs(start.second - target.second)

        if (deltaX != deltaY) {
            // Not a diagonal move
            return false
        }

        val stepX = if (start.first < target.first) 1 else -1
        val stepY = if (start.second < target.second) 1 else -1

        var x = start.first + stepX
        var y = start.second + stepY

        while (x != target.first || y != target.second) {
            if (pieceExistsAtPosition(Pair(x, y))) {
                return false
            }

            x += stepX
            y += stepY
        }

        return true
    }

     private fun pieceExistsAtPosition(position: Pair<Int, Int>): Boolean {
        //TODO
        return false;
    }
}
