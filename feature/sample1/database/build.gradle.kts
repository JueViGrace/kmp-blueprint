plugins {
    id("kmp-library")
    alias(libs.plugins.sqldelight)
}

kotlin {
    jvm()

    sourceSets {
        androidMain.dependencies {
            // Koin
            implementation(libs.koin.android)
        }

        commonMain.dependencies {
            // Database
            api(projects.core.database)

            // Util
            api(projects.core.util)

            // Koin
            implementation(libs.koin.core)
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
