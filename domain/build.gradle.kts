plugins {
    id(Plugins.JAVA_LIBRARY)
    id(Plugins.KOTLIN_JVM)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    with(Dependencies.Kotlin) {
        implementation(COROUTINES_CORE)
    }

    with(Dependencies.Hilt){
        implementation(JAVAX_INJECT)
    }
}