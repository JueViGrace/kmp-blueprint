plugins {
    id("kmp-library")
}

kotlin {
    androidTarget()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            // Database
            implementation(projects.sample2.database.sample2Database)

            // Network
            implementation(projects.sample2.network.sample2Network)

            // Types
            api(projects.core.types)
        }
    }
}

android {
    namespace = "com.jvg.sample2.types"
}
