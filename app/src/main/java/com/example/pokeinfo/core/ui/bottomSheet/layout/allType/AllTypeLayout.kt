package com.example.pokeinfo.core.ui.bottomSheet.layout.allType

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.pokeinfo.databinding.LayoutAllTypeBottomSheetBinding
import com.example.pokeinfo.databinding.LayoutFavoriteBottomSheetBinding

class AllTypeLayout
constructor(context: Context, closeCallBack : (() -> Unit)? = null) : LinearLayout(context) {

    private var binding: LayoutAllTypeBottomSheetBinding = LayoutAllTypeBottomSheetBinding.inflate(LayoutInflater.from(context), this, true)
}