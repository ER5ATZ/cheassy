package ch.eassy

import kotlin.reflect.ExperimentalAssociatedObjects
import kotlin.reflect.KClass
import kotlin.reflect.findAssociatedObject

actual class PlatformTesting<T : Annotation> actual constructor(kClass: KClass<Any>) {
    private val _kClass: KClass<Any> = kClass
    @OptIn(ExperimentalAssociatedObjects::class)
    @Suppress("UNCHECKED_CAST")
    actual fun returnClass(): T {
        val instance: Any? = _kClass.findAssociatedObject<Annotation>()

        return instance as T
    }

}