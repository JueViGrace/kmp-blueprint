plugins {
    id("kmp-library")
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
        }

        commonMain.dependencies {
            /* Projects */

            // Util
            implementation(projects.core.util)

            // Resources
            implementation(projects.core.resources)

            /* Dependencies */

            // Coroutines
            implementation(libs.kotlinx.coroutines.core)

            // Datetime
            implementation(libs.kotlinx.datetime)

            // Reflection
            implementation(libs.kotlin.reflect)
        }

        iosMain.dependencies {}

        jvmMain.dependencies {
            // Coroutines
            implementation(libs.kotlinx.coroutines.swing)
        }
    }
}

android {
    namespace = "com.jvg.kmpblueprint.types"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}
