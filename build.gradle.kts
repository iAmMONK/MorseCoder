buildscript {

    repositories {
        maven { url = uri("https://jitpack.io") }
        google()
        jcenter()
    }

    dependencies {
        classpath(BuildPlugins.androidGradlePlugin)
        classpath(BuildPlugins.kotlinGradlePlugin)
    }
}


repositories {
    maven { url = uri("https://jitpack.io") }
    google()
    jcenter()
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
