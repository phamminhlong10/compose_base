// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.ANDROID_APPLICATION) version Versions.GRADLE apply false
    id(Plugins.ANDROID_LIBRARY) version Versions.GRADLE apply false
    id(Plugins.KOTLIN_JVM) version Versions.KOTLIN apply false
    id(Plugins.KOTLIN_ANDROID) version Versions.KOTLIN apply false
    id(Plugins.HILT_ANDROID) version Versions.HILT apply false
}