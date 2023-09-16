import org.gradle.api.artifacts.dsl.DependencyHandler

// 기본 AndroidX Core
fun DependencyHandler.implementationAndroidXCore() {
    add("implementation", Dependencies.AndroidX.coreKtx)
    add("implementation", Dependencies.AndroidX.appcompat)
    add("implementation", Dependencies.AndroidX.annotation)
    add("implementation", Dependencies.AndroidX.constraintlayout)
    add("implementation", Dependencies.Google.material)
}

// LifeCycle
fun DependencyHandler.implementationLifecycle() {
    add("implementation", Dependencies.AndroidX.Lifecycle.viewModelKtx)
    add("implementation", Dependencies.AndroidX.Lifecycle.liveDataKtx)
    add("implementation", Dependencies.AndroidX.Lifecycle.runtimeKtx)
    add("implementation", Dependencies.AndroidX.Lifecycle.commonJava8)
}

// Room
fun DependencyHandler.implementationRoom() {
    add("implementation", Dependencies.AndroidX.Room.runtime)
    add("implementation", Dependencies.AndroidX.Room.roomKtx)
    add("implementation", Dependencies.AndroidX.Room.rxJava2)
    add("kapt", Dependencies.AndroidX.Room.compiler)
}

// RxJava2
fun DependencyHandler.implementationRxJava2() {
    add("implementation", Dependencies.ThirdParty.Reactivex.rxjava)
    add("implementation", Dependencies.ThirdParty.Reactivex.rxandroid)
    add("implementation", Dependencies.ThirdParty.Reactivex.rxKotlin)
    add("implementation", Dependencies.ThirdParty.Jakewharton.rxbinding)
    add("implementation", Dependencies.ThirdParty.Jakewharton.rxBindingMaterial)
}

// Retrofit, OkHttp, Gson
fun DependencyHandler.implementationRetrofitOkHttp() {
    add("implementation", Dependencies.SquareUp.retrofit)
    add("implementation", Dependencies.SquareUp.okhttp)
    add("implementation", Dependencies.SquareUp.converterGson)
    add("implementation", Dependencies.SquareUp.rxjava2)
    add("implementation", Dependencies.Google.gson)
}

// kakao (sdk)
fun DependencyHandler.implementationKakaoSdk() {
    add("implementation", Dependencies.Kakao.users)
    add("implementation", Dependencies.Kakao.share)
    add("implementation", Dependencies.Kakao.talk)
}

// facebook
fun DependencyHandler.implementationFacebook() {
    add("implementation", Dependencies.FaceBook.sdk)
    add("implementation", Dependencies.FaceBook.shimmer)
    add("implementation", Dependencies.FaceBook.stetho)
}

// 파이어베이스
fun DependencyHandler.implementationFirebase() {
    add("implementation", platform(Dependencies.Google.Firebase.bom))
    add("implementation", Dependencies.Google.Firebase.crashlyticsKtx)
    add("implementation", Dependencies.Google.Firebase.analyticsKtx)
    add("implementation", Dependencies.Google.Firebase.configKtx)
    add("implementation", Dependencies.Google.Firebase.core)
    add("implementation", Dependencies.Google.Firebase.messaging)
    add("implementation", Dependencies.Google.Firebase.dynamicLinks)
    add("implementation", Dependencies.Google.Firebase.perf)
}

// 플레이 서비스
fun DependencyHandler.implementationGms() {
    add("implementation", Dependencies.Google.Gms.base)
    add("implementation", Dependencies.Google.Gms.auth)
    add("implementation", Dependencies.Google.installreferrer)
    add("implementation", Dependencies.Google.Gms.adsIdentifier)
    add("implementation", Dependencies.Google.core)
}

// 구글 지도
fun DependencyHandler.implementationgoogleMap() {
    add("implementation", Dependencies.Google.Gms.maps)
    add("implementation", Dependencies.Google.Gms.places)
    add("implementation", Dependencies.Google.Gms.location)
}

// glide
fun DependencyHandler.implementationGlide() {
    add("implementation", Dependencies.ThirdParty.Github.glide)
    add("implementation", Dependencies.ThirdParty.Github.okhttp3)
    add("kapt", Dependencies.ThirdParty.Github.glideCompiler)
}

// Hilt
fun DependencyHandler.implementationHilt() {
    add("implementation", Dependencies.Google.Hilt.android)
    add("kapt", Dependencies.Google.Hilt.compiler)
    add("kapt", Dependencies.Google.Hilt.androidCompiler)
    add("testImplementation", Dependencies.Google.Hilt.androidTesting)
    add("kaptTest", Dependencies.Google.Hilt.androidCompiler)
}

fun DependencyHandler.implementationExoPlayer() {
    add("implementation", Dependencies.Google.exoplayerCore)
    add("kapt", Dependencies.Google.exoPlayUi)
}

fun DependencyHandler.implementationWindow() {
    add("implementation", Dependencies.AndroidX.window)
}

fun DependencyHandler.implementationOrbit() {
    add("implementation", Dependencies.ThirdParty.Oribit.core)
    add("implementation", Dependencies.ThirdParty.Oribit.viewmodel)
}