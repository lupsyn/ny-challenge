rootProject.name = "ny-challenge"

include(":app")
include(":domain")

include(":data:repository")
include(":data:network")

include(":libraries:core")
include(":libraries:test")
include(":libraries:designsystem")
include(":libraries:navigation")

include(":features:preference")
include(":features:search")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            from(files("buildSrc/libs.versions.toml"))
        }
    }
}
