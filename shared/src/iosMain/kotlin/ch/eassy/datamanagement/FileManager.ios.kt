package ch.eassy.datamanagement

import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSString
import platform.Foundation.NSURL
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.NSUserDomainMask
import platform.Foundation.URLByAppendingPathComponent
import platform.Foundation.create
import platform.Foundation.stringWithContentsOfURL
import platform.Foundation.writeToURL


actual class FileManager actual constructor() {
    @OptIn(ExperimentalForeignApi::class, BetaInteropApi::class)
    actual fun saveFile(fileName: String, content: String) {
        val fileDirectory = NSFileManager.defaultManager
            .URLsForDirectory(NSDocumentDirectory, NSUserDomainMask).last()!! as NSURL
        val filePath = fileDirectory.URLByAppendingPathComponent(fileName)
        val string = NSString.create(string = content)
        string
            .writeToURL(filePath!!, atomically = true, encoding = NSUTF8StringEncoding, error = null)
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun readFile(fileName: String): String? {
        val fileDirectory = NSFileManager.defaultManager
            .URLsForDirectory(NSDocumentDirectory, NSUserDomainMask).last()!! as NSURL
        val filePath = fileDirectory.URLByAppendingPathComponent(fileName)

        return NSString.stringWithContentsOfURL(filePath!!, NSUTF8StringEncoding, null)
    }
}