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
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "KMPBlueprint"

// build logic
includeBuild("build-logic")

// applications
include(
    ":apps:sampleApp1",
    ":apps:sampleApp2",
)

/*
* Core library
* */
include(
    ":core:network",
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

// shared network
include(
    ":shared:network:network-auth",
)

/*
* Sample1 library
*/

// database
include(
    ":sample1:database:sample1-database",
)

// features
include(
    ":sample1:feature:sample1-auth",
    ":sample1:feature:sample1-home",
)

// network
include(
    ":sample1:network:sample1-network",
)

// types
include(
    ":sample1:types:sample1-types",
)

/*
* Sample2 library
*/

// database
include(
    ":sample2:database:sample2-database",
)

// features
include(
    ":sample2:feature:sample2-auth",
    ":sample2:feature:sample2-home",
)

// network
include(
    ":sample2:network:sample2-network",
)

// types
include(
    ":sample2:types:sample2-types",
)
