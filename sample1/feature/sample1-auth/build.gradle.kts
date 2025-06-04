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
            // Koin
            implementation(libs.koin.android)
            implementation(libs.koin.androidx.compose)
            implementation(libs.koin.androidx.compose.navigation)
        }

        commonMain.dependencies {
            // Auth
            implementation(projects.shared.feature.featureAuth)

            // Database
            implementation(projects.sample1.database.sample1Database)

            // Koin
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            implementation(libs.koin.compose.viewmodel.navigation)

            // Network
            implementation(projects.sample1.network.sample1Network)

            // Types
            implementation(projects.sample1.types.sample1Types)
        }
    }
}

android {
    namespace = "com.jvg.sample1.auth"
}
