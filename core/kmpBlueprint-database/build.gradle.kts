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
            api(libs.sqldelight.android.driver)
        }

        commonMain.dependencies {
            // Util
            api(projects.core.kmpBlueprintUtil)

            // Sqldelight
            api(libs.sqldelight.async.extensions)
            api(libs.sqldelight.coroutines.extensions)
        }

        iosMain.dependencies {
            // Sqldelight
            api(libs.sqldelight.native.driver)
        }

        jvmMain.dependencies {
            // Sqldelight
            api(libs.sqldelight.sqlite.driver)

            // Sqlite
            implementation(libs.sqlite)
        }
    }
}

android {
    namespace = "com.jvg.kmpblueprint.database"
}
