package com.example.pokeinfo.core.ui.bottomSheet.layout

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.pokeinfo.databinding.LayoutFavoriteBottomSheetBinding

class FavoriteLayout
constructor(context: Context, closeCallBack : (() -> Unit)? = null) : LinearLayout(context) {

    private var binding: LayoutFavoriteBottomSheetBinding = LayoutFavoriteBottomSheetBinding.inflate(LayoutInflater.from(context), this, true)
}