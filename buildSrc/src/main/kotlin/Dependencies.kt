const val kotlinVersion = "1.4.20"

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "4.1.1"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "android"
    const val kotlinAndroidExtensions = "android.extensions"

}

object AndroidSdk {
    const val min = 16
    const val compile = 30
    const val target = compile
    const val buildTools = "30.0.2"
}

object Libraries {
    private object Versions {
        const val jetpack = "1.2.0"
        const val material = "1.2.1"
        const val ads = "19.5.0"
        const val ktx = "1.1.0-alpha05"
        const val core = "1.3.2"
    }

    const val kotlinStdLib     = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val appCompat        = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val material         = "com.google.android.material:material:${Versions.material}"
    const val ads              = "com.google.android.gms:play-services-ads:${Versions.ads}"
    const val core             = "androidx.core:core-ktx:${Versions.core}"
}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"
        const val testRunner = "1.1.0-alpha4"
        const val espresso = "3.1.0-alpha4"
    }
    const val junit4     = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso   = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}