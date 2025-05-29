plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.gradle.kotlin.gradlePlugin)
    implementation(libs.gradle.android.tools)
    implementation(libs.gradle.jetbrains.compose)
    implementation(libs.gradle.compose.compiler)
}

kotlin {
    jvmToolchain(21)
}
