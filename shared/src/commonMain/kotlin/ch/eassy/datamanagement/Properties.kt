package ch.eassy.datamanagement

class Properties {
    private val propertiesMap = mutableMapOf<String, String>()

    fun load(input: String) {
        val lines = input.lines()
        var currentKey: String? = null

        for (line in lines) {
            if (line.startsWith("#") || line.isBlank()) {
                continue
            }

            if (line.endsWith("\\")) {
                currentKey = currentKey?.let { it + line.dropLast(1) } ?: line.dropLast(1)
            } else {
                val (key, value) = parseProperty(line)
                currentKey = null

                if (key != null) {
                    propertiesMap[key] = value
                }
            }
        }
    }

    private fun parseProperty(line: String): Pair<String?, String> {
        val parts = line.split("=", limit = 2)
        return when (parts.size) {
            1 -> null to parts[0].trim()
            2 -> parts[0].trim() to parts[1].trim()
            else -> null to ""
        }
    }

    fun get(key: String): String? {
        return propertiesMap[key]
    }
}
