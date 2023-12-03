package com.example.pokeinfo.utils

import android.view.View
import android.view.animation.Animation
import com.example.pokeinfo.core.ui.animation.AnimationFactory
import com.example.pokeinfo.core.ui.animation.BaseAnimationListener
import com.facebook.shimmer.ShimmerFrameLayout

private const val MAX_ALPHA = 1f
private const val MIN_ALPHA = 0f
private const val DURATION_ALPHA = 600L
private const val OFFSET_ALPHA = 500L

fun stopShimmer(shimmerLayout : ShimmerFrameLayout){
    shimmerLayout.stopShimmer()
    shimmerLayout.visibility = View.GONE
}

fun startShimmer(shimmerLayout : ShimmerFrameLayout, contentLayout : View) {
    if(contentLayout.visibility == View.VISIBLE) return
    shimmerLayout.startShimmer()
}

fun stopShimmerLayout(shimmerLayout : ShimmerFrameLayout, contentLayout : View) {
    if(shimmerLayout.visibility == View.GONE) return

    AnimationFactory.alphaAnimation(MAX_ALPHA, MIN_ALPHA, DURATION_ALPHA, OFFSET_ALPHA).apply {
        setAnimationListener(object : BaseAnimationListener() {
            override fun onAnimationEnd(animation: Animation) {
                stopShimmer(shimmerLayout)
            }
        })
    }.let {
        shimmerLayout.startAnimation(it)
    }

    AnimationFactory.alphaAnimation(MIN_ALPHA, MAX_ALPHA, DURATION_ALPHA, OFFSET_ALPHA).apply {
        setAnimationListener(object : BaseAnimationListener() {
            override fun onAnimationStart(animation: Animation) {
                contentLayout.visibility = View.VISIBLE
            }
        })
    }.let {
        contentLayout.startAnimation(it)
    }
}