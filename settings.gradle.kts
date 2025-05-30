enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
enableFeaturePreview("STABLE_CONFIGURATION_CACHE")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

rootProject.name = "KMPBlueprint"

// build logic
includeBuild("build-logic")

// Applications
include(
    ":apps:sampleApp1",
    ":apps:sampleApp2",
)

// core library
include(
    ":core:kmpBlueprint-api",
    ":core:kmpBlueprint-database",
    ":core:kmpBlueprint-resources",
    ":core:kmpBlueprint-shared",
    ":core:kmpBlueprint-types",
    ":core:kmpBlueprint-ui",
    ":core:kmpBlueprint-util",
)

// feature library

// shared features
include(
    ":feature:shared:kmpBlueprint-app",
    ":feature:shared:kmpBlueprint-auth",
    ":feature:shared:kmpBlueprint-home",
)

// Sample1 features
include(
    ":feature:sample1:sample1-auth",
    ":feature:sample1:sample1-database",
    ":feature:sample1:sample1-home",
)

// Sample2 features
include(
    ":feature:sample2:sample2-auth",
    ":feature:sample2:sample2-database",
    ":feature:sample2:sample2-home",
)
