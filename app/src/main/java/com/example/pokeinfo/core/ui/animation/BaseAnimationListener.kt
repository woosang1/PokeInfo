/*
 * Created by Lee Oh Hyoung on 2020/06/04 .. 
 */
package com.example.pokeinfo.core.ui.animation

import android.view.animation.Animation

abstract class BaseAnimationListener : Animation.AnimationListener {

    override fun onAnimationStart(animation: Animation) { /* explicitly empty */
    }

    override fun onAnimationEnd(animation: Animation) { /* explicitly empty */
    }

    override fun onAnimationRepeat(animation: Animation) { /* explicitly empty */
    }
}
