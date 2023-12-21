package ch.eassy

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform