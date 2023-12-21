package ch.eassy.sprites

import ch.eassy.utils.Color
import ch.eassy.utils.Origin
import ch.eassy.utils.Sprite
import kotlin.math.abs
import ch.eassy.utils.Origin.East as east
import ch.eassy.utils.Origin.North as north
import ch.eassy.utils.Origin.South as south
import ch.eassy.utils.Origin.West as west

class Pawn(sprite: Sprite, color: Color, origins: List<Origin>): Piece(sprite, color, origins) {
    private var isFirstMove = true

    init {
        isFirstMove = true
        super.setType("Pawn")
    }

    override fun moveTo(targetTile: Tile) {
        super.moveTo(targetTile)
        if (isFirstMove) {
            isFirstMove = false
        }
    }

    override fun isLegalMove(tile: Tile): Boolean {
        return isLegalDefaultMove(tile)
                || isLegalFirstMove(tile)
                || isLegalAttack(tile)
    }

    private fun isLegalDefaultMove(tile: Tile): Boolean {
        val tilePiece = tile.getPiece()
        return tilePiece == null
                && isMoveInLegalDirection(getTile()!!.getLocation(), tile.getLocation(), Pair(0, 1))
                && isSafeMove(tile)
    }

    private fun isLegalFirstMove(tile: Tile): Boolean {
        val tilePiece = tile.getPiece()
        return isFirstMove
                && tilePiece == null
                && isMoveInLegalDirection(getTile()!!.getLocation(), tile.getLocation(), Pair(0, 2))
                && isSafeMove(tile)
    }

    private fun isLegalAttack(tile: Tile): Boolean {
        val tilePiece = tile.getPiece()
        return tilePiece != null
                && tilePiece.getColor() != getColor()
                && isMoveInLegalDirection(getTile()!!.getLocation(), tile.getLocation(), Pair(1, 1))
                && isSafeMove(tile)
    }

    private fun isMoveInLegalDirection(start: Pair<Int, Int>, target: Pair<Int, Int>, difference: Pair<Int, Int>): Boolean {
        // pawn only has one origin direction, other pieces may have two
        when (getOrigins()[0]) {
            north -> {
                // when moving down, we expect start y to be bigger than target y
                return start.second - target.second == difference.second
                        && abs(start.first - target.first) == difference.first
            }
            west -> {
                // when moving sideways x and y axis are switched
                return start.first - target.first == difference.second
                        && abs(start.second - target.second) == difference.first
            }
            east -> {
                // difference y corresponds to "forward" and y corresponds to a "side move"
                return target.first - start.first == difference.second
                        && abs(target.second - start.second) == difference.first
            }
            // on normal orientation, the pawns start on row 2 counting upwards
            south -> {
                return target.second - start.second == difference.second
                        && abs(target.first - start.first) == difference.first
            }
        }
    }
}