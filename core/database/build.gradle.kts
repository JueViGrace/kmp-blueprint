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
            // Sqldelight
            implementation(libs.sqldelight.android.driver)
        }

        commonMain.dependencies {
            // Util
            api(projects.core.util)

            // Sqldelight
            implementation(libs.sqldelight.async.extensions)
            implementation(libs.sqldelight.coroutines.extensions)
        }

        iosMain.dependencies {
            // Sqldelight
            implementation(libs.sqldelight.native.driver)
        }

        jvmMain.dependencies {
            // Sqldelight
            implementation(libs.sqldelight.sqlite.driver)

            // Sqlite
            api(libs.sqlite)
        }
    }
}

android {
    namespace = "com.jvg.kmpblueprint.database"
}
