package com.example.pokeinfo.utils

import android.content.res.Resources

/**
 * DP 값 가져오기
 */
val Int.dp: Float
    get() = this * Resources.getSystem().displayMetrics.density


/**
 * Px값을 DP로 변환
 */
fun Int.pxToDp(): Int =
    (this / Resources.getSystem().displayMetrics.density).toInt()

/**
 * Dp값을 PX로 변환
 */
fun Int.dpToPixel(): Int =
    (this * Resources.getSystem().displayMetrics.density).toInt()

/**
 * SP/DP -> EM로 변환
 */
fun Double.spToEm(): Float =(this * 0.0624).toFloat()
