package com.example.pokeinfo.core.ui.bottomSheet.layout

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.pokeinfo.databinding.LayoutAllTypeBottomSheetBinding
import com.example.pokeinfo.databinding.LayoutFavoriteBottomSheetBinding
import com.example.pokeinfo.databinding.LayoutGenerationsBottomSheetBinding

class GenerationsLayout
constructor(context: Context, closeCallBack : (() -> Unit)? = null) : LinearLayout(context) {

    private var binding: LayoutGenerationsBottomSheetBinding = LayoutGenerationsBottomSheetBinding.inflate(LayoutInflater.from(context), this, true)
}