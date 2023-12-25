package ch.eassy

import ch.eassy.utils.Players

class PlayerFactory {
    fun getPlayers(numberOfPlayers: Int): List<Players> {
        val players = mutableListOf<Players>()
        for (i in 0..numberOfPlayers) {
            players.add(Players.entries[i])
        }
        return players
    }
}