plugins {
    id("compose-multiplatform-library")
}

kotlin {
    androidTarget()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    jvm()

    sourceSets {
        commonMain.dependencies {
            // Api
            api(projects.core.kmpBlueprintApi)

            // Database
            api(projects.core.kmpBlueprintDatabase)

            // Resources
            api(projects.core.kmpBlueprintResources)

            // Types
            api(projects.core.kmpBlueprintTypes)

            // UI
            api(projects.core.kmpBlueprintUi)

            // Util
            api(projects.core.kmpBlueprintUtil)
        }
    }
}

android {
    namespace = "com.jvg.kmpblueprint.shared"
}
