package ch.eassy.utils

class GameSettings(type: GameTypes?, saveState: SaveState?) {
    val label: String = writeLabel()

    val type: GameTypes = determineType()
    val saveState: SaveState = createSaveState()


    private fun determineType(): GameTypes {
        TODO("Not yet implemented")
    }

    private fun createSaveState(): SaveState {
        TODO("Not yet implemented")
    }

    private fun writeLabel(): String {
        TODO("Not yet implemented")
    }
}