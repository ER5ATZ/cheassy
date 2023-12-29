package ch.eassy.datamanagement

import android.annotation.SuppressLint

actual class FileManager actual constructor() {
    private val application = AndroidApplicationWrapper.instance()

    actual fun saveFile(fileName: String, content: String) {
        /*FileOutputStream(File(context.filesDir, fileName)).use {
            it.write(content.toByteArray())
        }*/
    }

    actual fun readFile(fileName: String): String? {
        return ""
        /*return try {
            FileInputStream(File(context.filesDir, fileName)).use {
                it.reader().readText()
            }
        } catch (e: Exception) {
            null
        }*/
    }

    @SuppressLint("DiscouragedApi")
    @Deprecated("Only use during App development")
    actual fun readRawFile(fileName: String): String {
        with(application) {
            val resourceId = resources.getIdentifier(
                fileName.substringBefore("."), "raw", packageName
            )
            return resources.openRawResource(resourceId)
                .bufferedReader().readText()
        }
    }
}