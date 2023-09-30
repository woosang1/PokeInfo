package com.example.pokeinfo.utils

import PokemonColorUtil
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("setImageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    imageView.setImageUrl(url)
}

@BindingAdapter("setBackgroundByType")
fun setBackgroundByType(view: View, typeList: List<String>?) {
    typeList?.let {
        val color = PokemonColorUtil(view.context).getPokemonColor(typeList)
        view.setBackgroundColor(color)
    }
}