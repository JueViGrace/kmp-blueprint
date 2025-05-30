plugins {
    id("kmp-library")
}

kotlin {
    jvm()

    sourceSets {
        androidMain.dependencies {
            // Sqldelight
            api(libs.sqldelight.android.driver)
        }

        commonMain.dependencies {
            // Util
            api(projects.core.util)

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
