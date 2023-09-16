//// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.6.0" apply false
    id("com.android.library") version "8.1.1" apply false
}

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.gradleVersion}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}")
        classpath("org.jetbrains.kotlin:kotlin-android-extensions:${Versions.kotlinVersion}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}")
    }
}

//allprojects {
//    repositories {
//        google()
//        mavenLocal()
//        mavenCentral()
//        flatDir { dirs("libs") }
//        maven { url = uri("https://jitpack.io") }
//        maven { url = uri("https://maven.google.com/") }
//        maven { url = uri("https://sdk-download.airbridge.io/maven") }
//        maven { url = uri("https://naver.jfrog.io/artifactory/maven/") }
//        maven { url = uri("https://appboy.github.io/appboy-android-sdk/sdk") }
//        maven { url = uri("https://devrepo.kakao.com/nexus/content/groups/public/") }
//    }
//}

//tasks.register("clean", Delete::class) {
//    delete(rootProject.buildDir)
//}