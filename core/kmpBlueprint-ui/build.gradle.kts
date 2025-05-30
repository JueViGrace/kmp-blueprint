plugins {
    id("compose-multiplatform-library")
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    androidTarget()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    jvm()

    sourceSets {
        androidMain.dependencies {
            // Camera
            implementation(libs.androidx.camera.core)
            implementation(libs.androidx.camera.camera2)
            implementation(libs.androidx.camera.lifecycle)
            implementation(libs.androidx.camera.video)
            implementation(libs.androidx.camera.view)
            implementation(libs.androidx.camera.extensions)
            implementation(libs.androidx.camera.compose)
        }

        commonMain.dependencies {
            // Resources
            api(projects.core.kmpBlueprintResources)

            // Types
            api(projects.core.kmpBlueprintTypes)

            // Util
            api(projects.core.kmpBlueprintUtil)

            // Serialization
            implementation(libs.kotlinx.serialization.json)
        }
    }
}

android {
    namespace = "com.jvg.kmpblueprint.ui"
}
