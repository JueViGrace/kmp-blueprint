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
        commonMain.dependencies {
            // Network
            implementation(projects.core.network)
        }
    }
}

android {
    namespace = "com.jvg.kmpblueprint.network.auth"
}
