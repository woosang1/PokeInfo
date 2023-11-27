package com.example.pokeinfo.utils

import android.app.Activity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.window.layout.FoldingFeature
import androidx.window.layout.WindowInfoTracker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * 가로형 폴드폰 상태 얻기.
 * [doubleScreenModeCallBack] - 폴더폰 펼쳐진 상태
 * [singleScreenMode] - 일반폰 및 폴더폰 접은 상태
 */
fun Activity.checkFolderPhone(
    lifecycleOwner : LifecycleOwner,
    lifecycle: Lifecycle,
    doubleScreenModeCallBack: (() -> Unit),
    singleScreenModeCallback: (() -> Unit)
) {
    lifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
        lifecycle.repeatOnLifecycle(Lifecycle.State.CREATED) {
            WindowInfoTracker.getOrCreate(this@checkFolderPhone)
                .windowLayoutInfo(this@checkFolderPhone)
                .collect { layoutInfo ->
                    // 듀얼모니터 상태.
                    if (layoutInfo.displayFeatures.isNotEmpty()) {
                        val foldingFeature = layoutInfo.displayFeatures
                            .filterIsInstance<FoldingFeature>()
                            .firstOrNull()

                        // 접힌 상태 입니까
                        if (!checkIsOpenFoldedDisplay(foldingFeature)) {
                            singleScreenModeCallback.invoke()
                        }

                        // 펼쳐진 상태.
                        else {
                            doubleScreenModeCallBack.invoke()
                        }
                    }
                    // 싱글 모니터 상태. (일반폰)
                    else {
                        singleScreenModeCallback.invoke()
                    }
                }
        }
    }
}

// 폴더폰(플립X)에서 펼쳐진 상태 입니까?
/**
 * FoldingFeature.State.FLAT - 완전 오픈
 * FoldingFeature.State.HALF_OPENED - 절반 오픈
 * FoldingFeature.State.HALF_OPENED - null 접힌 상태
 */
fun checkIsOpenFoldedDisplay(foldFeature: FoldingFeature?) : Boolean{
    return if (foldFeature != null){
        (foldFeature.orientation ==  FoldingFeature.Orientation.VERTICAL) &&
                ((foldFeature.state == FoldingFeature.State.FLAT) ||
                        (foldFeature.state == FoldingFeature.State.HALF_OPENED))
    }
    else{
        false
    }
}