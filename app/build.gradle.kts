plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    buildToolsVersion("30.0.2")
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.programming.monk.morsecodetranslator"
        minSdkVersion(16)
        targetSdkVersion(30)
        versionCode = 20
        versionName = "2.0"
        multiDexEnabled = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        targetCompatibility = org.gradle.api.JavaVersion.VERSION_1_8
        sourceCompatibility = org.gradle.api.JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlin("stdlib-jdk8", "1.4.20"))
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.2.1")
    implementation("com.google.android.gms:play-services-ads:19.5.0")
    implementation("androidx.core:core-ktx:1.3.2")
}
repositories {
    mavenCentral()
    google()
}

fun getExt(name: String) = project.rootProject.ext[name]