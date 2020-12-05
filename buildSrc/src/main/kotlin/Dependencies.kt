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
        const val ads = "19.5.0"
        const val timber = "4.7.1"
        const val glide = "4.11.0"
    }

    const val kotlinStdLib     = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val ads              = "com.google.android.gms:play-services-ads:${Versions.ads}"

    const val timber           = "com.jakewharton.timber:timber:${Versions.timber}"
    const val glide            = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideKtx         = "com.github.bumptech.glide:compiler:${Versions.glide}"
}

object AndroidLibraries {
    private object Versions {
        const val jetpack = "1.2.0"
        const val material = "1.2.1"
        const val core = "1.3.2"
        const val navigation = "2.3.2"
        const val constraintLayout = "2.0.4"
        const val fragment = "1.2.5"
        const val lifeCycle = "2.2.0"
    }

    const val navigation            = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi          = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationModules     = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"
    const val fragment              = "androidx.fragment:fragment-ktx:${Versions.fragment}"

    const val appCompat             = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val core                  = "androidx.core:core-ktx:${Versions.core}"
    const val viewModel             = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycle}"
    const val liveData              = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycle}"
    const val liveDataRx            = "androidx.lifecycle:lifecycle-reactivestreams-ktx:${Versions.lifeCycle}"
    const val liveDataKapt          = "androidx.lifecycle:lifecycle-compiler:${Versions.lifeCycle}"

    const val constraintLayout      = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val material              = "com.google.android.material:material:${Versions.material}"
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