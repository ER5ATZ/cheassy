package ch.eassy

import kotlin.random.Random
import ch.eassy.datamanagement.MokoResourcesProvider
import ch.eassy.datamanagement.PropertiesProvider

class Greeting(
    private val properties: PropertiesProvider,
    private val mokoResources: MokoResourcesProvider,
) {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        val firstWord = if (Random.Default.nextBoolean()) "Hi!" else "Hello!"

        return "$firstWord Guess what this is! > ${platform.name.reversed()}!"
    }


}