plugins {
    id("kmp-application")
}

kotlin {
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
            // Auth
            implementation(projects.feature.sample2.auth)

            // Database
            implementation(projects.feature.sample2.database)

            // Home
            implementation(projects.feature.sample2.home)
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
}

dependencies {
    debugImplementation(compose.uiTooling)
}
