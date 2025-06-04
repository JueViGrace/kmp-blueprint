plugins {
    id("kmp-library")
    alias(libs.plugins.sqldelight)
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
        }

        commonMain.dependencies {
            // Database
            api(projects.core.database)

            // Koin
            implementation(libs.koin.core)

            // Sqldelight
            implementation(libs.sqldelight.async.extensions)
            implementation(libs.sqldelight.coroutines.extensions)
        }
    }
}

android {
    namespace = "com.jvg.sample1.database"
}

sqldelight {
    databases {
        create("Sample1DB") {
            packageName.set("com.jvg.sample1.database")
            schemaOutputDirectory.set(file("src/commonMain/sqldelight/databases"))
            generateAsync.set(true)
            deriveSchemaFromMigrations.set(true)
            verifyMigrations.set(true)
        }
    }
}
