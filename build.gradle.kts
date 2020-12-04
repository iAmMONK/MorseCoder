buildscript {

    repositories {
        maven { url = uri("https://jitpack.io") }
        google()
        jcenter()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:4.1.1")
        classpath(kotlin("gradle-plugin", "1.4.20"))
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
