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
}

android {
    namespace = "com.jvg.kmpblueprint.resources"
}

compose.resources {
    generateResClass = always
    publicResClass = true
}
