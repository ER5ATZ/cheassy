package ch.eassy.utils

enum class Pieces(private val code: Char) {
    King('K'),
    Queen('Q'),
    Rook('R'),
    Bishop('B'),
    Knight('N'),
    Pawn('P'),

    ;

    companion object {
        fun byCode(code: String):  Pieces? {
            for (piece in entries) {
                if (piece.name.startsWith(code.uppercase())) {
                    return piece
                }
            }

            error("Code ${code} did not match any possible Piece")
        }
    }

}