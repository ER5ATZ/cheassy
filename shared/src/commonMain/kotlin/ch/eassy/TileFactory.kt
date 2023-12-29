package ch.eassy

import ch.eassy.sprites.Board
import ch.eassy.sprites.Tile
import ch.eassy.utils.Colors

class TileFactory {

    fun generateTiles(boardSizes: List<Pair<Int, Int>>): Map<String, Board> {
        val boards = HashMap<String, Board>()
        var xOffset = 0f
        var yOffset = 0f

        for ((boardNumber, boardSize) in boardSizes.withIndex()) {
            val board = generateBoard(boardSize.first, boardSize.second, xOffset)
            boards.put("board$boardNumber", board)
            xOffset += boardSize.first + 1
        }

        return boards
    }

    private fun generateBoard(x: Int, y: Int, boardOff: Float): Board {
        val board = Board(x, y, boardOff)

        for (row in 0 until y) {
            for (col in 0 until x) {
                val isBlack = (row + col) % 2 == 1
                val tileColor = if (isBlack) Colors.Black else Colors.White
                val tile = Tile(
                    name = "${('A' + col).toChar()}${row + 1}",
                    //position = Pair(boardOff + col, /*yOffset +*/ row),
                    color = tileColor.color,
                    location = Pair(col + 1, row + 1)
                )

                board.add(tile)
            }
        }

        return board
    }
}
