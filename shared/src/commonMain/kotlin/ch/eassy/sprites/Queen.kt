package ch.eassy.sprites

import ch.eassy.utils.Color
import ch.eassy.utils.Origin
import ch.eassy.utils.Sprite

import kotlin.math.abs

class Queen(sprite: Sprite, color: Color, origins: List<Origin>): Piece(sprite, color, origins) {
    override fun isLegalMove(tile: Tile): Boolean {
        val start = getTile().getLocation()
        val target = tile.getLocation()
        val targetPiece = tile.getPiece()

        return (isMoveInLegalDirection(start, target)
                && (isStraightPathFree(start, target)
                || isDiagonalPathFree(start, target)))
                && isLegalAttack(targetPiece)
                && isSafeMove(tile)
    }

    private fun isMoveInLegalDirection(start: Pair<Int, Int>, target: Pair<Int, Int>): Boolean {
        // queen can move horizontally, vertically, or diagonally
        return start.first == target.first
                || start.second == target.second
                || abs(start.first - target.first) == abs(start.second - target.second)
    }
}
