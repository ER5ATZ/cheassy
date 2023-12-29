package ch.eassy

import ch.eassy.sprites.Bishop
import ch.eassy.sprites.Board
import ch.eassy.sprites.King
import ch.eassy.sprites.Knight
import ch.eassy.sprites.Pawn
import ch.eassy.sprites.Piece
import ch.eassy.sprites.Queen
import ch.eassy.sprites.Rook
import ch.eassy.sprites.Tile
import ch.eassy.utils.Color
import ch.eassy.utils.Colors
import ch.eassy.utils.Origins
import ch.eassy.utils.Pieces
import ch.eassy.utils.Players

class PieceFactory {
    private var lightColor: Color = Colors.White.color
    private var darkColors: List<Color> = listOf()
    fun createAndSetPieces(
        boards: MutableMap<String, Board>,
        playerColors: MutableMap<Players, Color>,
        distribution: String
    ) {
        setColors(playerColors)
        val positions = distribution.split(',')
        var currentBoard = 1

        positions.forEach {
            if (it.trim() == "") {
                // empty element indicates a new board
                currentBoard++
                return
            }

            val colorCode = it.substring(1, 2)
            val color = assignColor(colorCode) ?: error("Color for $colorCode could not be assigned.")

            val origin = assignOrigin(it.substring(1, 2))

            val pieceCode = it.substring(0, 1)

            val board: Board? = boards["board$currentBoard"]
            val tile = board!!.getTile(it.substring(2))
            createAndPlacePiece(pieceCode, tile!!, color, origin)
        }
    }

    private fun setColors(colors: Map<Players, Color>) {
        darkColors = colors.values.filter { it != lightColor }
    }

    private fun assignColor(colorCode: String): Color? {
        return when (colorCode.lowercase()) {
            "w" -> lightColor
            else -> darkColors.getOrNull(colorCode.toInt() - 1)
        }
    }

    private fun createAndPlacePiece(code: String, tile: Tile, color: Color, origin: String) {
        val origins = Origins.findOrigins(origin)
        val piece = createPiece(code, color, origins, tile)
        // should we add the created pieces to an additional collection?

    }

    private fun assignOrigin(colorCode: String): String {
        return when (colorCode.lowercase()) {
            // TODO needs revisit when more variants are added
            "b" -> "n,e"
            "g" -> "s,e"
            "r" -> "n,w"
            "w" -> "s,w"
            else -> ""
        }
    }

    private fun createPiece(code: String, color: Color, origins: List<Origins>, tile: Tile): Piece? {
        return when (Pieces.byCode(code)) {
            Pieces.King -> King(color, origins, tile)
            Pieces.Queen -> Queen(color, origins, tile)
            Pieces.Bishop -> Bishop(color, origins, tile)
            Pieces.Knight -> Knight(color, origins, tile)
            Pieces.Rook -> Rook(color, origins, tile)
            Pieces.Pawn -> Pawn(color, origins, tile)
            else -> null
        }
    }
}