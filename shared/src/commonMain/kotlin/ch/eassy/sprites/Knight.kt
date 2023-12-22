package ch.eassy.sprites

import ch.eassy.utils.Color
import ch.eassy.utils.Origin
import ch.eassy.utils.Sprite

import kotlin.math.abs

class Knight(sprite: Sprite, color: Color, origins: List<Origin>): Piece(sprite, color, origins) {
    override fun isLegalMove(tile: Tile): Boolean {
        val start = getTile().getLocation()
        val target = tile.getLocation()
        val targetPiece = tile.getPiece()

        return isLShapedMove(start, target) && isLegalAttack(targetPiece) && isSafeMove(tile)
    }

    private fun isLShapedMove(start: Pair<Int, Int>, target: Pair<Int, Int>): Boolean {
        val deltaX = abs(start.first - target.first)
        val deltaY = abs(start.second - target.second)

        return (deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2)
    }
}
