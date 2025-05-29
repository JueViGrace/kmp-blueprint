plugins {
    id("compose-multiplatform-library")
}

// todo: generate resources from gradle.properties or local.properties and add them as a generated resource

kotlin {
    androidTarget()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    jvm()

    sourceSets {
        androidMain.dependencies {}

        commonMain.dependencies {
            // Compose
            implementation(compose.runtime)
            implementation(compose.components.resources)
        }

        iosMain.dependencies {}

        jvmMain.dependencies {
            // Compose
            implementation(compose.desktop.common)
        }
    }
}

android {
    namespace = "com.jvg.kmpblueprint.resources"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

compose.resources {
    publicResClass = true
}
