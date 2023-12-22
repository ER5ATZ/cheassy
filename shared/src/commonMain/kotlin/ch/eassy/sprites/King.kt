package ch.eassy.sprites

import ch.eassy.utils.Color
import ch.eassy.utils.Origin
import ch.eassy.utils.Sprite

import kotlin.math.abs

class King(sprite: Sprite, color: Color, origins: List<Origin>): Piece(sprite, color, origins) {
    override fun isLegalMove(tile: Tile): Boolean {
        val start = getTile().getLocation()
        val target = tile.getLocation()
        val targetPiece = tile.getPiece()

        return isMoveWithinRange(start, target)
                && isMoveInLegalDirection(tile)
                && isLegalAttack(targetPiece)
                && isSafeMove(tile)
    }

    private fun isMoveInLegalDirection(tile: Tile): Boolean {
        // no need to check for the classic game, but variations might add restrictions
        return true
    }

    private fun isMoveWithinRange(start: Pair<Int, Int>, target: Pair<Int, Int>): Boolean {
        // king can move to any adjacent square
        return abs(start.first - target.first) <= 1 && abs(start.second - target.second) <= 1
    }
}
