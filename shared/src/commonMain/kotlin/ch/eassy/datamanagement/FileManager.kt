package ch.eassy.datamanagement

expect class FileManager() {
    fun saveFile(fileName: String, content: String)
    fun readFile(fileName: String): String?
}