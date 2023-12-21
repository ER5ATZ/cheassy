package ch.eassy.sprites

class Board(x: Int, y: Int, boardOff: Float) {
    private var tiles = mutableListOf<Tile>()
    fun add(tile: Tile) {
        tiles.add(tile)
    }

    fun getTile(name: String): Tile? {
        return tiles.find { t-> name.equals(t.getName()) }
    }
}