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

/*
* Shared library
*/

// shared features
include(
    ":shared:feature:feature-app",
    ":shared:feature:feature-auth",
    ":shared:feature:feature-home",
)

// shared
include(
    ":shared:network:network-auth",
    ":shared:network:network-home",
)

/*
* Sample1 library
*/

include(
    ":sample1:database:sample1-database",
    ":sample1:feature:sample1-auth",
    ":sample1:feature:sample1-home",
)

/*
* Sample2 library
*/

include(
    ":sample2:database:sample2-database",
    ":sample2:feature:sample2-auth",
    ":sample2:feature:sample2-home",
)
