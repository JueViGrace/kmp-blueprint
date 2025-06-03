plugins {
    id("kmp-library")
    alias(libs.plugins.sqldelight)
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
        }

        commonMain.dependencies {
            // Database
            api(projects.core.database)

            // Koin
            implementation(libs.koin.core)
        }
    }
}

android {
    namespace = "com.jvg.sample2.database"
}

sqldelight {
    databases {
        create("Sample2DB") {
            packageName.set("com.jvg.sample2.database")
            schemaOutputDirectory.set(file("src/commonMain/sqldelight/databases"))
            generateAsync.set(true)
            deriveSchemaFromMigrations.set(true)
            verifyMigrations.set(true)
        }
    }
}
