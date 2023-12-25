package ch.eassy.sprites

import kotlin.math.abs
import ch.eassy.utils.Color
import ch.eassy.utils.Origins
import ch.eassy.utils.Pieces.Knight
import ch.eassy.utils.Sprite

class Knight(color: Color, origins: List<Origins>, tile: Tile): Piece(Sprite.get(Knight), color, origins) {

    init {
        setTile(tile)
        setType(Knight.name)
    }
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
