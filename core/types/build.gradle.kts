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
