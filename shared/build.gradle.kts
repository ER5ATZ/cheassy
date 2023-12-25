import dev.icerock.gradle.MRVisibility

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("dev.icerock.mobile.multiplatform-resources")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    applyDefaultHierarchyTemplate()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.5.0")
                implementation("dev.icerock.moko:resources:0.23.0")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation("dev.icerock.moko:resources-test:0.23.0")
            }
        }
    }

    // for more info: https://github.com/icerockdev/moko-resources
    multiplatformResources {
        multiplatformResourcesPackage = "ch.eassy.libs" // required
        multiplatformResourcesClassName = "MokoResources" // optional, default MR
        multiplatformResourcesVisibility = MRVisibility.Public // optional, default Public
        iosBaseLocalizationRegion = "en" // optional, default "en"
        multiplatformResourcesSourceSet = "commonMain" // optional, default "commonMain"
    }
}

android {
    namespace = "ch.eassy"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}

dependencies {
    implementation("androidx.core:core-ktx:+")
}
