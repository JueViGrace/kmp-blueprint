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
        commonMain.dependencies {
            // App
            implementation(projects.shared.feature.featureApp)

            // Auth
            implementation(projects.sample2.feature.sample2Auth)

            // Database
            implementation(projects.sample2.database.sample2Database)

            // Home
            implementation(projects.sample2.feature.sample2Home)

            // Network
            implementation(projects.sample2.network.sample2Network)
        }
    }
}

android {
    namespace = "com.jvg.sample2"

    defaultConfig {
        applicationId = "com.jvg.sample2"
        versionCode = libs.versions.sampleApp2VersionCode.get().toInt()
        versionName = libs.versions.sampleApp2VersionName.get()
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
