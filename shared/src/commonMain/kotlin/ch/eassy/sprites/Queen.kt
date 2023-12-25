package ch.eassy.sprites

import kotlin.math.abs
import ch.eassy.utils.Color
import ch.eassy.utils.Origins
import ch.eassy.utils.Pieces.Queen
import ch.eassy.utils.Sprite

class Queen(color: Color, origins: List<Origins>, tile: Tile): Piece(Sprite.get(Queen), color, origins) {
    init {
        setTile(tile)
        setType(Queen.name)
    }

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
