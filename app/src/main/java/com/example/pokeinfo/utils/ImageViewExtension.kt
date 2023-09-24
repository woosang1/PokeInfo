package com.example.pokeinfo.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setImageUrl(url: String?) {
    if (url == null) return
    Glide.with(this).load(url).into(this)
}