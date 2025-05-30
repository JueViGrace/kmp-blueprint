plugins {
    id("compose-multiplatform-library")
}

kotlin {
    jvm()

    sourceSets {
        commonMain.dependencies {
            /* Projects */

            // Api
            api(projects.core.api)

            // Database
            api(projects.core.database)

            // Resources
            api(projects.core.resources)

            // Types
            api(projects.core.types)

            // UI
            api(projects.core.ui)

            // Util
            api(projects.core.util)
        }
    }
}

android {
    namespace = "com.jvg.kmpblueprint.shared"
}
