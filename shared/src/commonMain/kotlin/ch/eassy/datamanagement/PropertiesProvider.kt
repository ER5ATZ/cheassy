package ch.eassy.datamanagement

class PropertiesProvider(fileReader: FileManager) {
    private val properties: Properties = loadProperties(fileReader)

    private fun loadProperties(fileReader: FileManager): Properties {
        val properties = Properties()
        val fileContent = fileReader.readFile("game.properties")
        properties.load(fileContent!!)
        return properties
    }

    fun getProperty(key: String): String? {
        return properties.get(key)
    }

    fun getProperty(key: String, default: String): String {
        return properties.get(key) ?: default
    }
}
