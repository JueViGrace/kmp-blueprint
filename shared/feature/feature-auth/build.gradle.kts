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
        commonMain.dependencies {
            // Network
            implementation(projects.shared.network.networkAuth)

            // Shared
            api(projects.core.shared)
        }
    }
}

android {
    namespace = "com.jvg.kmpblueprint.auth"
}
