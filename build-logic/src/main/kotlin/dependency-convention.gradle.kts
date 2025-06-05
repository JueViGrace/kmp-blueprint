import blueprintbuild.internal.kotlin
import blueprintbuild.internal.libs
import blueprintbuild.targets.hasTarget

plugins {
    id("kmp-convention")
}

kotlin {
    sourceSets {
        androidMain.dependencies {
            implementation(libs.androidx.core.ktx)
            implementation(libs.androidx.activity.compose)

            api(libs.kotlinx.coroutines.android)
        }

        commonMain.dependencies {
            api(libs.kotlinx.coroutines.core)

            api(libs.kotlinx.datetime)

            implementation(libs.kotlin.reflect)
        }

        iosMain.dependencies {}

        hasTarget("jvm") {
            jvmMain.dependencies {
                api(libs.kotlinx.coroutines.swing)

                api(libs.logback.classic)
            }
        }
    }
}
