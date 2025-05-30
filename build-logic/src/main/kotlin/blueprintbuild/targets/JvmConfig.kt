package blueprintbuild.targets

import blueprintbuild.internal.kotlin
import blueprintbuild.internal.libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.invoke

internal fun Project.configureJvm() {
    kotlin {
        hasTarget("jvm") {
            sourceSets {
                jvmMain.dependencies {
                    api(libs.kotlinx.coroutines.swing)
                }
            }
        }
    }
}
