plugins {
    id("compose-multiplatform-library")
}

kotlin {
    jvm()

    sourceSets {
        commonMain.dependencies {
            // Api
            api(projects.core.api)

            // Database
            api(projects.core.database)

            // Resources
            api(projects.core.resources)

            // Shared
            api(projects.core.shared)

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
    namespace = "com.jvg.kmpblueprint.app"
}
