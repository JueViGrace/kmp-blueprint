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
        commonMain.dependencies {
            // Database
            implementation(projects.sample1.database.sample1Database)

            // Network
            implementation(projects.sample1.network.sample1Network)

            // Types
            api(projects.core.types)
        }
    }
}

android {
    namespace = "com.jvg.sample1.types"
}
