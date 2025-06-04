import org.jetbrains.compose.desktop.application.dsl.TargetFormat

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
            baseName = "SampleApp1"
            isStatic = true
        }
    }

    jvm()

    sourceSets {
        commonMain.dependencies {
            // App
            implementation(projects.shared.feature.featureApp)

            // Auth
            implementation(projects.sample1.feature.sample1Auth)

            // Database
            implementation(projects.sample1.database.sample1Database)

            // Home
            implementation(projects.sample1.feature.sample1Home)

            // Network
            implementation(projects.sample1.network.sample1Network)
        }
    }
}

android {
    namespace = "com.jvg.sample1"

    defaultConfig {
        applicationId = "com.jvg.sample1"
        versionCode = libs.versions.sampleApp1VersionCode.get().toInt()
        versionName = libs.versions.sampleApp1VersionName.get()
    }

    buildTypes {
        all {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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
}
