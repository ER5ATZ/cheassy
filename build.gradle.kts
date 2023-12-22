plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("8.2.0").apply(false)
    id("com.android.library").version("8.2.0").apply(false)
    id("com.github.ben-manes.versions").version("0.50.0").apply(true)
    kotlin("android").version("1.9.21").apply(false)
    kotlin("multiplatform").version("1.9.21").apply(false)
}

buildscript {
    repositories {
        gradlePluginPortal()
    }

    dependencies {
        classpath("com.github.ben-manes:gradle-versions-plugin:0.50.0")
    }
}

tasks {
    register("checkUpdates") {
        dependsOn("dependencyUpdates")
    }

    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}

