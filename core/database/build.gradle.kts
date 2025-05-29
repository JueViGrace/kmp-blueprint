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

            // Sqldelight
            implementation(libs.sqldelight.android.driver)
        }

        commonMain.dependencies {
            /* Projects */

            // Util
            implementation(projects.core.util)

            /* Dependencies */

            // Coroutines
            implementation(libs.kotlinx.coroutines.core)

            // Sqldelight
            implementation(libs.sqldelight.async.extensions)
            implementation(libs.sqldelight.coroutines.extensions)
        }

        iosMain.dependencies {
            // Sqldelight
            implementation(libs.sqldelight.native.driver)
        }

        jvmMain.dependencies {
            // Coroutines
            implementation(libs.kotlinx.coroutines.swing)

            // Sqldelight
            implementation(libs.sqldelight.sqlite.driver)

            // Sqlite
            implementation(libs.sqlite)
        }
    }
}

android {
    namespace = "com.jvg.kmpblueprint.database"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}
