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
            // Koin
            implementation(libs.koin.android)
        }

        commonMain.dependencies {
            // Network
            api(projects.core.network)
            api(projects.shared.network.networkAuth)

            // Koin
            implementation(libs.koin.core)
        }
    }
}

android {
    namespace = "com.jvg.sample1.network"
}
