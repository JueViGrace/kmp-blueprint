plugins {
    id("kmp-library")
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    androidTarget()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    jvm()

    sourceSets {
        androidMain.dependencies {
            // Coroutines
            implementation(libs.kotlinx.coroutines.android)

            // Ktor: engine
            implementation(libs.ktor.client.okhttp)
        }

        commonMain.dependencies {
            /* Projects */
            implementation(projects.core.util)

            /* Dependencies */
            // Coroutines
            implementation(libs.kotlinx.coroutines.core)

            // Konnection
            implementation(libs.konnection)

            // Ktor
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.serialization.kotlinx.json)

            // Serialization
            implementation(libs.kotlinx.serialization.json)

            // Reflect
            implementation(libs.kotlin.reflect)
        }

        iosMain.dependencies {
            // Ktor: engine
            implementation(libs.ktor.client.darwin)
        }

        jvmMain.dependencies {
            // Coroutines
            implementation(libs.kotlinx.coroutines.swing)

            // Ktor: engine
            implementation(libs.ktor.client.okhttp)
        }
    }
}

android {
    namespace = "com.jvg.kmpblueprint.api"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}
