package ch.eassy

import kotlin.reflect.KClass

expect class PlatformTesting<T: Annotation>(kClass: KClass<Any>) {
    fun returnClass(): T
}
