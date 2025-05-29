plugins {
    id("compose-multiplatform-library")
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
            // Android
            implementation(libs.androidx.core.ktx)
            implementation(libs.androidx.activity.compose)

            // Camera
            implementation(libs.androidx.camera.core)
            implementation(libs.androidx.camera.camera2)
            implementation(libs.androidx.camera.lifecycle)
            implementation(libs.androidx.camera.video)
            implementation(libs.androidx.camera.view)
            implementation(libs.androidx.camera.extensions)
            implementation(libs.androidx.camera.compose)

            // Coroutines
            implementation(libs.kotlinx.coroutines.android)
        }

        commonMain.dependencies {
            /* Projects */

            // Resources
            implementation(projects.core.resources)

            // Types
            implementation(projects.core.types)

            // Util
            implementation(projects.core.util)

            /* Dependencies */

            // Compose
            implementation(compose.animation)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(compose.foundation)
            implementation(compose.materialIconsExtended)
            implementation(compose.material3)
            implementation(compose.runtime)
            implementation(compose.ui)

            // Coroutines
            implementation(libs.kotlinx.coroutines.core)

            // Images
            implementation(libs.coil.compose)
            implementation(libs.coil.core)
            implementation(libs.coil.ktor3)
            implementation(libs.coil.cache)

            // Lifecycle
            implementation(libs.lifecycle.runtime.compose)

            // Navigation
            implementation(libs.navigation.compose)

            // Serialization
            implementation(libs.kotlinx.serialization.json)
        }

        iosMain.dependencies {}

        jvmMain.dependencies {
            // Compose
            implementation(compose.desktop.common)

            // Coroutines
            implementation(libs.kotlinx.coroutines.swing)
        }
    }
}

android {
    namespace = "com.jvg.kmpblueprint.ui"
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
