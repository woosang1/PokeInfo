package com.example.pokeinfo.core.ui.animation

import android.animation.ValueAnimator
import android.view.View
import android.view.animation.*

object AnimationFactory {

    const val ANIMATION_SELF = Animation.RELATIVE_TO_SELF

    fun transLateAnimation(animationType: Int, fromX: Float, toX: Float,
                           fromY: Float, toY: Float, duraion: Long): Animation {
        return transLateAnimation(animationType, fromX, toX, fromY, toY, duraion, 0)
    }

    /**
     * 이동 애니메이션 생성
     *
     * @param animationType 애니메이션 타입
     * @param fromX         커지기 전 x 값
     * @param toX           커진 후 x 값
     * @param fromY         커지기 전 y 값
     * @param toY           커진 후 y 값
     * @param duraion       진행 될 시간인
     * @param offset        시작 전 대기시간
     * @return 설정이 완료된 애니메이션
     */
    fun transLateAnimation(animationType: Int, fromX: Float, toX: Float,
                           fromY: Float, toY: Float, duraion: Long, offset: Long): Animation {
        val transAnimation: Animation = TranslateAnimation(animationType, fromX, animationType, toX, animationType, fromY, animationType, toY)
        transAnimation.duration = duraion
        transAnimation.interpolator = AccelerateInterpolator()
        transAnimation.startOffset = offset
        return transAnimation
    }

    /**
     * 이동 애니메이션 생성
     *
     * @param fromDegrees   회전 전 위치
     * @param toDegrees     회전 후 위치
     * @param pivotXType    x 애니메이션 타입
     * @param pivotXValue   x의 중간점
     * @param pivotYType    y 애니메이션 타입
     * @param pivotYValue   y의 중간점
     * @param duraion       진행 될 시간
     * @param offset        시작 전 대기시간
     * @return 설정이 완료된 애니메이션
     */
    fun rotateAnimation(fromDegrees: Float, toDegrees: Float, pivotXType: Int, pivotXValue: Float,
                        pivotYType: Int, pivotYValue: Float, duraion: Long, offset: Long): Animation {
        val rotateAnimation: Animation = RotateAnimation(fromDegrees, toDegrees, pivotXType, pivotXValue, pivotYType, pivotYValue)
        rotateAnimation.duration = duraion
        rotateAnimation.interpolator = AccelerateInterpolator()
        rotateAnimation.startOffset = offset
        rotateAnimation.fillAfter = true
        return rotateAnimation
    }

    fun scaleAnimation(animationType: Int, fromX: Float, toX: Float,
                       fromY: Float, toY: Float, pivotXValue: Float, pivotYValue: Float, duraion: Long): Animation {
        return scaleAnimation(animationType, fromX, toX, fromY, toY, pivotXValue, pivotYValue, duraion, 0)
    }

    /**
     * 크기 애니메이션 생성
     *
     * @param animationType 애니메이션 타입
     * @param fromX         커지기 전 x 값
     * @param toX           커진 후 x 값
     * @param fromY         커지기 전 y 값
     * @param toY           커진 후 y 값
     * @param pivotXValue   x의 중간점
     * @param pivotYValue   y의 중간점
     * @param duraion       진행 될 시간
     * @param offset        시작 전 대기시간
     * @return
     */
    fun scaleAnimation(animationType: Int, fromX: Float, toX: Float,
                       fromY: Float, toY: Float, pivotXValue: Float, pivotYValue: Float, duraion: Long, offset: Long): Animation {
        val scaleAnimation: Animation = ScaleAnimation(fromX, toX, fromY, toY, animationType, pivotXValue, animationType, pivotYValue)
        scaleAnimation.duration = duraion
        scaleAnimation.startOffset = offset
        return scaleAnimation
    }

    /**
     * 투명 애니메이션 생성
     *
     * @param from     보이기전 알파값
     * @param to       보인 후 알파값
     * @param duration 진행 될 시간
     * @param offset   시작 전 대기시간
     * @return
     */
    fun alphaAnimation(from: Float, to: Float, duration: Long, offset: Long): Animation {
        val alphaAnimation: Animation = AlphaAnimation(from, to)
        alphaAnimation.duration = duration
        alphaAnimation.interpolator = AccelerateInterpolator()
        alphaAnimation.startOffset = offset
        return alphaAnimation
    }



    // 열리는 애니메이션 (가로)
    fun expand(v: View, duration: Int, targetWidth: Int) {
        val prevWidth = v.width
        val valueAnimator = ValueAnimator.ofInt(prevWidth, targetWidth)
        valueAnimator.addUpdateListener { animation ->
            v.layoutParams.width = animation.animatedValue as Int
            v.requestLayout()
        }
        valueAnimator.interpolator = DecelerateInterpolator()
        valueAnimator.duration = duration.toLong()
        valueAnimator.start()
    }

    // 작아지는 애니메이션 (가로)
    fun collapse(v: View, duration: Int, targetWidth: Int) {
        val prevWidth = v.width
        val valueAnimator = ValueAnimator.ofInt(prevWidth, targetWidth)
        valueAnimator.interpolator = DecelerateInterpolator()
        valueAnimator.addUpdateListener { animation ->
            v.layoutParams.width = animation.animatedValue as Int
            v.requestLayout()
        }
        valueAnimator.interpolator = DecelerateInterpolator()
        valueAnimator.duration = duration.toLong()
        valueAnimator.start()
    }

    // 열리는 애니메이션 (세로)
    fun heightExpand(v: View, duration: Int, targetHeight: Int) {
        val prevHeight = v.height
        val valueAnimator = ValueAnimator.ofInt(prevHeight, targetHeight)
        valueAnimator.addUpdateListener { animation ->
            v.layoutParams.height = animation.animatedValue as Int
            v.requestLayout()
        }
        valueAnimator.interpolator = DecelerateInterpolator()
        valueAnimator.duration = duration.toLong()
        valueAnimator.start()
    }

    // 작아지는 애니메이션 (세로)
    fun heightCollapse(v: View, duration: Int, targetHeight: Int) {
        val prevHeight = v.height
        val valueAnimator = ValueAnimator.ofInt(prevHeight, targetHeight)
        valueAnimator.addUpdateListener { animation ->
            v.layoutParams.height = animation.animatedValue as Int
            v.requestLayout()
        }
        valueAnimator.interpolator = DecelerateInterpolator()
        valueAnimator.duration = duration.toLong()
        valueAnimator.start()
    }


}