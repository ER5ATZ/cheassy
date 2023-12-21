package ch.eassy.utils

enum class Origin {
    North,
    West,
    East,
    South;

    companion object {
        fun findOrigins(origin: String): List<Origin> {
            val originList = mutableListOf<Origin>()
            val origins = Origin.values()
            for (char in origin) {
                for (o in origins) {
                    if (o.toString().lowercase().startsWith(char)) originList.add(o)
                }
            }

            return originList
        }
    }
}
