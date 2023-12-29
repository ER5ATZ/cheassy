package ch.eassy.utils

enum class Screens(val label: String, val color: Colors) {
    Menu("ChEsS iS eAsY", Colors.Turquoise),
    About("Credits", Colors.LightPink),
    PlayGame("", Colors.LightGreen),
    Settings("Settings", Colors.LightBlue),
    SavedGame("Save Games", Colors.LightPurple),
    ChooseGame("Chess Variations", Colors.LightYellow),
    ColorPicker("Player Color", Colors.LightOrange),
    ;
}