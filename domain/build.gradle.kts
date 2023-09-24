plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
//    kotlin("android")
}

android {
    namespace = ConfigData.applicationId
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

//    implementation(project(":data"))

    // AndroidX-Core
    implementationAndroidXCore()
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Glide
    implementationGlide()

    // Retrofit, OkHttp, Gson
    implementationRetrofitOkHttp()

    // RxJava2
    implementationRxJava2()

    // lifeCycle
    implementationLifecycle()
    implementation(Dependencies.AndroidX.activity)
    implementation(Dependencies.AndroidX.fragment)
//    implementation(Dependencies.AndroidX.navigationCompose)

    // room
    implementationRoom()

    // hlit
    implementationHilt()

    // Orbit
    implementationOrbit()
}