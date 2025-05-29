plugins {
    id("kmp-application")
}

kotlin {
    androidTarget()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "SampleApp2"
            isStatic = true
        }
    }

    sourceSets {
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
            implementation(projects.feature.sample2.auth)

            // Database
            implementation(projects.core.database)
            implementation(projects.feature.sample2.database)

            // Home
            implementation(projects.feature.sample2.home)

            // Resources
            implementation(projects.core.resources)

            // Shared
            implementation(projects.core.shared)

            // Types
            implementation(projects.core.types)

            // UI
            implementation(projects.core.ui)

            // Util
            implementation(projects.core.util)

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
    }
}

android {
    namespace = "com.jvg.sample2"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.jvg.sample2"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = libs.versions.sampleApp2VersionCode.get().toInt()
        versionName = libs.versions.sampleApp2VersionName.get()
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

compose.resources {
    generateResClass = never
}

dependencies {
    debugImplementation(compose.uiTooling)
}
