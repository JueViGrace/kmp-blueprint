plugins {
    id("compose-multiplatform-library")
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

            // Koin
            implementation(libs.koin.android)
        }

        commonMain.dependencies {
            /* Projects */

            // Api
            implementation(projects.core.api)

            // Database
            implementation(projects.core.database)

            // Resources
            implementation(projects.core.resources)

            // Types
            implementation(projects.core.types)

            // UI
            implementation(projects.core.ui)

            // Util
            implementation(projects.core.util)

            /* Dependencies */

            // Compose
            implementation(compose.runtime)
            implementation(compose.components.resources)

            // Coroutines
            implementation(libs.kotlinx.coroutines.core)

            // Lifecycle
            implementation(libs.lifecycle.runtime.compose)
            implementation(libs.lifecycle.viewmodel)
            implementation(libs.lifecycle.viewmodel.compose)
            implementation(libs.lifecycle.viewmodel.savedstate)

            // Koin
            implementation(libs.koin.core)

            // Navigation
            implementation(libs.navigation.compose)
        }

        iosMain.dependencies {}

        jvmMain.dependencies {
            // Coroutines
            implementation(libs.kotlinx.coroutines.swing)
        }
    }
}

android {
    namespace = "com.jvg.kmpblueprint.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

compose.resources {
    generateResClass = never
}
