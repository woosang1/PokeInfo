package com.example.pokeinfo.core.ui.bottomSheet.layout.generations

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Generation(
    val id: Int,
    @StringRes val title: Int,
    @DrawableRes val image: Int
)