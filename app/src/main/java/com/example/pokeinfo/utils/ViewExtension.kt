package com.example.pokeinfo.utils

import android.animation.AnimatorListenerAdapter
import android.os.SystemClock
import android.view.HapticFeedbackConstants
import android.view.View
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter


fun View.setOnAnimationClickListener(callback: (view: View) -> Unit) {
    this.setOnClickListener {
        setClickAnimation(callback)
    }
}

fun View.setClickAnimation(callback: (view: View) -> Unit) {
    val toggleDuration = 80
    val animationMinScale = 0.925f

    try {
        this.apply {
            isClickable = false
            animate().run {
                scaleXBy(1f)
                scaleX(animationMinScale)
                scaleYBy(1f)
                scaleY(animationMinScale)
                duration = toggleDuration.toLong()
                setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: android.animation.Animator) {
                        super.onAnimationEnd(animation)
                        animate().run {
                            scaleX(1f)
                            scaleY(1f)
                            duration = toggleDuration.toLong()
                            setListener(object : AnimatorListenerAdapter() {
                                override fun onAnimationEnd(animation: android.animation.Animator) {
                                    super.onAnimationEnd(animation)
                                    isClickable = true
                                    callback.invoke(this@apply)
                                }
                            })
                        }
                    }
                })
            }
        }

    } catch (e: Exception) {
        callback.invoke(this)
    }
}

infix fun View.changeVisibleView(outView: View) {
    this.visibility = View.GONE
    outView.visibility = View.VISIBLE
}

fun View.setOnSingleClickListener(block: () -> Unit) {
    setOnClickListener(OnSingleClickListener(block))
}

//fun View.setBackgroundDrawableResource(@DrawableRes drawableId: Int) {
//    background = context.getDrawableCompat(drawableId)
//}

fun View.setHapTic() {
    this.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_TAP)
}


private class OnSingleClickListener(private val block: () -> Unit) : View.OnClickListener {

    private var lastClickTime = 0L

    override fun onClick(view: View) {
        if (SystemClock.elapsedRealtime() - lastClickTime > 1000) {
            lastClickTime = SystemClock.elapsedRealtime()
            block()
        }
    }
}

