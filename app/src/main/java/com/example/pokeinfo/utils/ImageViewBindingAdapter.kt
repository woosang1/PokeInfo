package com.example.pokeinfo.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("setImageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    imageView.setImageUrl(url)
}