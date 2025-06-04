plugins {
    id("compose-multiplatform-library")
}

kotlin {
    androidTarget()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        androidMain.dependencies {
            // Koin
            implementation(libs.koin.android)
            implementation(libs.koin.androidx.compose)
            implementation(libs.koin.androidx.compose.navigation)
        }

        commonMain.dependencies {
            // Auth
            implementation(projects.shared.feature.featureAuth)

            // Database
            implementation(projects.sample2.database.sample2Database)

            // Koin
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            implementation(libs.koin.compose.viewmodel.navigation)

            // Network
            implementation(projects.sample2.network.sample2Network)

            // Types
            implementation(projects.sample2.types.sample2Types)
        }
    }
}

android {
    namespace = "com.jvg.sample2.auth"
}
