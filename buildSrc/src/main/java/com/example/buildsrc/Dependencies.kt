
object Dependencies {

    val junit = "junit:junit:4.13.2"
    val kotlinxCoroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4"
    val mockk = "io.mockk:mockk:1.12.0"
    val jdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"

    object AndroidX {
        val core = "androidx.core:core:${Versions.coreKtx}"
        val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        val annotation = "androidx.annotation:annotation:${Versions.annotation}"
        val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
        val coreTesting = "androidx.arch.core:core-testing:2.1.0"
        val activity = "androidx.activity:activity-ktx:1.6.1"
        val fragment = "androidx.fragment:fragment-ktx:1.6.1"
        val navigationCompose = "androidx.navigation:navigation-compose:1.1.0"
        val workRuntimeKtx = "androidx.work:work-runtime-ktx:2.7.1"
        val window = "androidx.window:window:${Versions.window}"
        val swiperefreshlayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"

        object Lifecycle {
            val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
            val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
            val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
            val commonJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
        }

        object Room {
            val runtime = "androidx.room:room-runtime:${Versions.room}"
            val roomKtx = "androidx.room:room-ktx:${Versions.room}"
            val rxJava2 = "androidx.room:room-rxjava2:${Versions.room}"
            val compiler = "androidx.room:room-compiler:${Versions.room}"
        }
    }

    object Android {
        val extensions = "android.arch.lifecycle:extensions:1.1.1"
    }

    object Google {
        val material = "com.google.android.material:material:${Versions.material}"
        val installreferrer = "com.android.installreferrer:installreferrer:2.2"
        val core = "com.google.android.play:core:1.10.3"
        val gson = "com.google.code.gson:gson:2.8.9"
        val flexbox = "com.google.android.flexbox:flexbox:3.0.0"

        object Firebase {
            val bom = "com.google.firebase:firebase-bom:30.1.0"
            val crashlyticsKtx = "com.google.firebase:firebase-crashlytics-ktx"
            val analyticsKtx = "com.google.firebase:firebase-analytics-ktx"
            val configKtx = "com.google.firebase:firebase-config-ktx:21.0.2"
            val core = "com.google.firebase:firebase-core:21.0.0"
            val messaging = "com.google.firebase:firebase-messaging:23.0.5"
            val dynamicLinks = "com.google.firebase:firebase-dynamic-links:21.0.1"
            val perf = "com.google.firebase:firebase-perf:20.1.0"
        }

        object Hilt {
            val android = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
            val compiler = "com.google.dagger:hilt-compiler:${Versions.hiltVersion}"
            val androidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}"
            val androidTesting = "com.google.dagger:hilt-android-testing:${Versions.hiltVersion}"
        }
    }

    object SquareUp {
        val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        val okhttp = "com.squareup.okhttp3:okhttp:4.8.1"
        val converterGson = "com.squareup.retrofit2:converter-gson:2.9.0"
        val rxjava2 = "com.squareup.retrofit2:adapter-rxjava2:2.9.0"
        val picasso = "com.squareup.picasso:picasso:2.71828"
    }

    object FaceBook {
        val shimmer = "com.facebook.shimmer:shimmer:0.5.0"
    }

    object ThirdParty {
        val lottie = "com.airbnb.android:lottie:5.2.0"
        val speedDial = "com.leinardi.android:speed-dial:3.3.0"

        object Reactivex {
            val rxjava = "io.reactivex.rxjava2:rxjava:2.2.19"
            val rxandroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
            val rxKotlin = "io.reactivex.rxjava2:rxkotlin:2.4.0"
        }

        object Jakewharton {
            val rxbinding = "com.jakewharton.rxbinding4:rxbinding:${Versions.rxbinding}"
            val rxBindingMaterial = "com.jakewharton.rxbinding4:rxbinding-material:${Versions.rxbinding}"
        }

        object Github {
            val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
            val okhttp3 = "com.github.bumptech.glide:okhttp3-integration:${Versions.glide}"
            val jwt = "com.github.PhilJay:JWT:1.1.5"
            val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
        }

        object Oribit {
            val core = "org.orbit-mvi:orbit-core:${Versions.orbit}"
            val viewmodel = "org.orbit-mvi:orbit-viewmodel:${Versions.orbit}"
        }
    }

}