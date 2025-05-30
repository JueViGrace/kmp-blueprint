plugins {
    id("kmp-library")
}

kotlin {
    jvm()

    sourceSets {
        commonMain.dependencies {
            // Resources
            api(projects.core.resources)

            // Util
            api(projects.core.util)
        }
    }
}

android {
    namespace = "com.jvg.kmpblueprint.types"
}
