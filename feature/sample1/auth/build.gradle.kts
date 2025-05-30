plugins {
    id("compose-multiplatform-library")
}

kotlin {
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
            implementation(projects.feature.shared.auth)

            // Database
            implementation(projects.feature.sample1.database)

            // Koin
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            implementation(libs.koin.compose.viewmodel.navigation)
        }
    }
}

android {
    namespace = "com.jvg.sample1.auth"
}
