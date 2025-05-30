plugins {
    id("compose-multiplatform-library")
}

kotlin {
    sourceSets {
        androidMain.dependencies {
            // Koin
            implementation(libs.koin.android)
            implementation(libs.koin.androidx.compose)
            implementation(libs.koin.androidx.compose.navigation)
        }

        commonMain.dependencies {
            // Database
            implementation(projects.feature.sample2.database)

            // Home
            implementation(projects.feature.shared.home)

            // Koin
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            implementation(libs.koin.compose.viewmodel.navigation)
        }
    }
}

android {
    namespace = "com.jvg.sample2.home"
}

