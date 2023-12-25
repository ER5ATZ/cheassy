package ch.eassy.sprites

import kotlin.math.abs
import ch.eassy.utils.Color
import ch.eassy.utils.Origins
import ch.eassy.utils.Pieces.Bishop
import ch.eassy.utils.Sprite

class Bishop(color: Color, origins: List<Origins>, tile: Tile): Piece(Sprite.get(Bishop), color, origins) {
    init {
        setTile(tile)
        setType(Bishop.name)
    }

    override fun isLegalMove(tile: Tile): Boolean {
        val start = getTile().getLocation()
        val target = tile.getLocation()
        val targetPiece = tile.getPiece()

        return isMoveInLegalDirection(start, target)
                && isDiagonalPathFree(start, target)
                && isLegalAttack(targetPiece)
                && isSafeMove(tile)
    }

    private fun isMoveInLegalDirection(start: Pair<Int, Int>, target: Pair<Int, Int>): Boolean {
        // bishop moves diagonally
        val deltaX = abs(start.first - target.first)
        val deltaY = abs(start.second - target.second)
        return deltaX == deltaY
    }
}
