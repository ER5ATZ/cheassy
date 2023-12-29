package ch.eassy

import kotlin.reflect.KClass

actual class PlatformTesting<T: Annotation> actual constructor(kClass: KClass<Any>) {
    private val _kClass = kClass
    @Suppress("UNCHECKED_CAST")
    actual fun returnClass(): T {
        val instance = _kClass.java.kotlin.objectInstance
        return instance as T
    }
}