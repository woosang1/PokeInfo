plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = ConfigData.applicationId
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = ConfigData.applicationId
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    // room
    implementationRoom()

    // hlit
    implementationHilt()

    // Orbit
    implementationOrbit()

    // window
    implementationWindow()

}