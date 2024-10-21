import org.jetbrains.kotlin.konan.properties.loadProperties

plugins {
    id(Plugins.ANDROID_APPLICATION)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.KOTLIN_KAPT)
    id(Plugins.KOTLIN_PARCELIZE)
    id(Plugins.HILT_ANDROID)
}

val signingProperties = loadProperties("$rootDir/signing.properties")
val getVersionCode: () -> Int = {
    if (project.hasProperty("versionCode")) {
        (project.property("versionCode") as String).toInt()
    } else {
        Versions.ANDROID_VERSION_CODE
    }
}

android {
    namespace = "com.compose.base"
    compileSdk = Versions.ANDROID_COMPILE_SDK

    defaultConfig {
        applicationId = "com.compose.base"
        minSdk = Versions.ANDROID_MIN_SDK
        targetSdk = Versions.ANDROID_TARGET_SDK
        versionCode = 1
        versionName = Versions.ANDROID_VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        buildConfigField("String", "BASE_API_URL", "\"https://jsonplaceholder.typicode.com/\"")
    }

    signingConfigs{
        create(BuildTypes.RELEASE) {
            // Remember to edit signing.properties to have the correct info for release build.
            storeFile = file("../config/release.keystore")
            storePassword = signingProperties.getProperty("KEYSTORE_PASSWORD") as String
            keyPassword = signingProperties.getProperty("KEY_PASSWORD") as String
            keyAlias = signingProperties.getProperty("KEY_ALIAS") as String
            //buildConfigField("String", "BASE_API_URL", "\"https://jsonplaceholder.typicode.com/\"")
        }

        getByName(BuildTypes.DEBUG) {
            storeFile = file("../config/debug.keystore")
            storePassword = "oQ4mL1jY2uX7wD8q"
            keyAlias = "debug-key-alias"
            keyPassword = "oQ4mL1jY2uX7wD8q"
            //buildConfigField("String", "BASE_API_URL", "\"https://jsonplaceholder.typicode.com/\"")
        }
    }

    flavorDimensions += Flavors.VERSION
    productFlavors {
        create(Flavors.STAGING) {
            applicationIdSuffix = ".staging"
        }

        create(Flavors.PRODUCTION) {}
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isDebuggable = false
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE_COMPILER
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(Modules.DATA))
    implementation(project(Modules.DOMAIN))

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    with(Dependencies.AndroidX) {
        implementation(CORE_KTX)
        implementation(LIFECYCLE_RUNTIME_KTX)
        implementation(LIFECYCLE_RUNTIME_COMPOSE)
        implementation(DATASTORE_PREFERENCES)
    }

    with(Dependencies.Compose) {
        implementation(platform(BOM))
        implementation(UI)
        implementation(UI_TOOLING)
        implementation(MATERIAL)
        implementation(NAVIGATION)

        implementation(ACCOMPANIST_PERMISSIONS)
    }

    with(Dependencies.Hilt) {
        implementation(ANDROID)
        implementation(NAVIGATION_COMPOSE)
        kapt(COMPILER)
    }

    with(Dependencies.Log) {
        implementation(TIMBER)

        debugImplementation(CHUCKER)
        releaseImplementation(CHUCKER_NO_OP)
    }
}