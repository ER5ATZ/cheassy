package ch.eassy.utils

import ch.eassy.sprites.Board
import ch.eassy.sprites.Tile

class SaveState(private val type: GameTypes, private val players: List<Players>, private val positions: List<String>?) {
    private val _boards = determineBoards()

    private fun determineBoards(): Map<String, Board> {
        val result = emptyBoard()
        if (positions.isNullOrEmpty()) {
            defaultPositions(result)
        } else {
            setSavedPositions(result)
        }
        return result
    }

    private fun emptyBoard(): Map<String, Board> {
        TODO("Get Boards Setup by Game Type and return a map with empty boards")
    }

    private fun defaultPositions(boards: Map<String, Board>) {
        TODO("Get Pieces Setup by Game Type and Player Colors, and set them on the boards")
    }

    private fun setSavedPositions(boards: Map<String, Board>) {
        TODO("Get Pieces Setup from Positions and Player Colors, and set them on the boards")
    }

    private fun setPositions(boards: Map<String, Board>, pieces: Map<String, String>) {
        TODO("Set Pieces and update boards")
    }

    fun updatePosition(from: Tile, to: Tile) {
        TODO("Remove potential target piece from TO, " +
                "move piece from FROM to TO, " +
                "update boards, save local file")
    }

    fun boards(): Map<String, Board> {
        return _boards
    }
}