package ch.eassy

import ch.eassy.sprites.Board
import ch.eassy.utils.Color
import ch.eassy.utils.Colors
import ch.eassy.utils.Players

class BoardFactory() {
    private val tileFactory = TileFactory()
    private val pieceFactory = PieceFactory()
    private val playerFactory =  PlayerFactory()
    //private val sizes: List<Pair<Int, Int>> = listOf(Pair(8, 8))
    //private val players: List<String> = listOf("Player1", "Player2")
    //using default game values for the beginning
    private val distribution =
        "RwA1,NwB1,BwC1,KwD1,QwE1,BwF1,NwG1,RwH1,PwA2,PwB2,PwC2,PwD2,PwE2,PwF2,PwG2,PwH2," +
                "RbA8,NbB8,BbC8,KbD8,QbE8,BbF8,NbG8,RbH8,PbA7,PbB7,PbC7,PbD7,PbE7,PbF7,PbG7,PbH7"

    fun getBoards(numberOfPlayers: Int, sizes : List<Pair<Int, Int>>): Map<String, Board> {
        val playerColors: MutableMap<Players, Color> = mutableMapOf()
        val boards: MutableMap<String, Board> = mutableMapOf()
        var color = Colors.White.color
        val players = playerFactory.getPlayers(numberOfPlayers)

        // TODO this whole part might become obsolete once we have new sprites
        players.forEach { player ->
            playerColors[player] = color
            color = Color.create(255,
                maxOf(0, color.red - 1 / 255),
                maxOf(0, color.green - 1 / 255),
                maxOf(0, color.blue - 1 / 255))
        }

        boards.putAll(tileFactory.generateTiles(sizes))
        pieceFactory.createAndSetPieces(boards, playerColors, distribution)

        return boards
    }
}