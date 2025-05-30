import blueprintbuild.targets.hasTarget

plugins {
    id("kmp-library")
    id("compose-multiplatform-convention")
}

kotlin {
    sourceSets {
        hasTarget("jvm") {
            jvmMain.dependencies {
                // Compose
                implementation(compose.desktop.common)
            }
        }
    }
}
