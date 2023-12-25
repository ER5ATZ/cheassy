package ch.eassy.datamanagement

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import android.content.Context

actual class FileManager actual constructor() {

    private val context: Context = TODO()

    actual fun saveFile(fileName: String, content: String) {
        FileOutputStream(File(context.filesDir, fileName)).use {
            it.write(content.toByteArray())
        }
    }

    actual fun readFile(fileName: String): String? {
        return try {
            FileInputStream(File(context.filesDir, fileName)).use {
                it.reader().readText()
            }
        } catch (e: Exception) {
            null
        }
    }
}