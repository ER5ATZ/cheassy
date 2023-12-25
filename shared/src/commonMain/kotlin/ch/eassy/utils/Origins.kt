package ch.eassy.utils

enum class Origins {
    North,
    West,
    East,
    South;

    companion object {
        fun findOrigins(origin: String): List<Origins> {
            val originList = mutableListOf<Origins>()
            val origins = Origins.values()
            for (char in origin) {
                for (o in origins) {
                    if (o.toString().lowercase().startsWith(char)) originList.add(o)
                }
            }

            return originList
        }
    }
}
