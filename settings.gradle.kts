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
    ":core:api",
    ":core:database",
    ":core:resources",
    ":core:shared",
    ":core:types",
    ":core:ui",
    ":core:util",
)

// feature library

// shared features
include(
    ":feature:shared:app",
    ":feature:shared:auth",
    ":feature:shared:home",
)

// Sample1 features
include(
    ":feature:sample1:auth",
    ":feature:sample1:database",
    ":feature:sample1:home",
)

// Sample2 features
include(
    ":feature:sample2:auth",
    ":feature:sample2:database",
    ":feature:sample2:home",
)
