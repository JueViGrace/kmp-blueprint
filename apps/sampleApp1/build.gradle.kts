import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = "com.jvg.sample1"

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "SampleApp1"
            isStatic = true
        }
    }

    jvm("desktop")

    sourceSets {
        val desktopMain by getting
        androidMain.dependencies {
            // Android
            implementation(libs.androidx.core.ktx)
            implementation(libs.androidx.activity.compose)

            // App update
            implementation(libs.androidx.app.update)
            implementation(libs.androidx.app.update.ktx)

            // Coroutines
            implementation(libs.kotlinx.coroutines.android)

            // Koin
            implementation(libs.koin.android)
            implementation(libs.koin.androidx.compose)
        }
        commonMain.dependencies {
            /* Projects */

            // Api
            implementation(projects.core.api)

            // App
            implementation(projects.feature.shared.app)

            // Auth
            implementation(projects.feature.sample1.auth)

            // Database
            implementation(projects.feature.sample1.database)

            // Home
            implementation(projects.feature.sample1.home)

            // Resources
            implementation(projects.core.resources)

            // UI
            implementation(projects.core.ui)

            /* Dependencies */

            // Compose
            implementation(compose.animation)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(compose.foundation)
            implementation(compose.materialIconsExtended)
            implementation(compose.material3)
            implementation(compose.runtime)
            implementation(compose.ui)

            // Coroutines
            implementation(libs.kotlinx.coroutines.core)

            // Koin
            implementation(libs.koin.core)
            implementation(libs.koin.compose)

            // Navigation
            implementation(libs.navigation.compose)

            // Reflect
            implementation(libs.kotlin.reflect)
        }
        desktopMain.dependencies {
            // Compose
            implementation(compose.desktop.common)

            // Coroutines
            implementation(libs.kotlinx.coroutines.swing)
        }
    }
}

android {
    namespace = "com.jvg.sample1"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.jvg.sample1"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = libs.versions.sampleApp1VersionCode.get().toInt()
        versionName = libs.versions.sampleApp1VersionName.get()

        vectorDrawables {
            useSupportLibrary = true
        }
    }
    packaging {
        resources.excludes += "DebugProbesKt.bin"
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("Boolean", "IS_DEBUG", "false")
        }
        debug {
            isMinifyEnabled = false
            isShrinkResources = false
            isDebuggable = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("Boolean", "IS_DEBUG", "true")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }
}

compose {
    desktop {
        application {
            mainClass = "com.jvg.sample1.ApplicationKt"

            nativeDistributions {
                targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
                packageName = "com.jvg.sample1"
                packageVersion = libs.versions.sampleApp1VersionName.get()
            }
        }
    }

    resources {
        generateResClass = never
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}
