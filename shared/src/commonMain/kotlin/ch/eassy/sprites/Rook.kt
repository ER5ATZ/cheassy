package ch.eassy.sprites

import ch.eassy.utils.Color
import ch.eassy.utils.Origins
import ch.eassy.utils.Pieces.Rook
import ch.eassy.utils.Sprite

class Rook(color: Color, origins: List<Origins>, tile: Tile): Piece(Sprite.get(Rook), color, origins) {
    init {
        setTile(tile)
        setType(Rook.name)
    }

    override fun isLegalMove(tile: Tile): Boolean {
        val start = getTile().getLocation()
        val target = tile.getLocation()
        val targetPiece = tile.getPiece()

        return isMoveInLegalDirection(start, target)
                && isStraightPathFree(start, target)
                && isLegalAttack(targetPiece)
                && isSafeMove(tile)
    }

    private fun isMoveInLegalDirection(start: Pair<Int, Int>, target: Pair<Int, Int>): Boolean {
        // rook moves either horizontally or vertically
        return start.first == target.first || start.second == target.second
    }
}
