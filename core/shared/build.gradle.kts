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
            // Api
            api(projects.core.network)

            // Database
            api(projects.core.database)

            // Resources
            api(projects.core.resources)

            // Types
            api(projects.core.types)

            // UI
            api(projects.core.ui)

            // Util
            api(projects.core.util)
        }
    }
}

android {
    namespace = "com.jvg.kmpblueprint.shared"
}
